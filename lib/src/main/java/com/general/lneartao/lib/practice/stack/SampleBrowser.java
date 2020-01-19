package com.general.lneartao.lib.practice.stack;

/**
 * 使用前后栈实现浏览器的前进后退。
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class SampleBrowser {

    private String currentPage;
    private StackBasedOnLinkedList<String> backStack;
    private StackBasedOnLinkedList<String> forwardStack;

    public SampleBrowser() {
        backStack = new StackBasedOnLinkedList<>();
        forwardStack = new StackBasedOnLinkedList<>();
    }

    public void open(String url) {
        if (currentPage != null) {
            backStack.push(currentPage);
            forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public boolean canGoBack() {
        return backStack.getSize() > 0;
    }

    public boolean canGoForward() {
        return forwardStack.getSize() > 0;
    }

    public String goBack() {
        if (canGoBack()) {
            forwardStack.push(currentPage);
            String backUrl = backStack.pop();
            showUrl(backUrl, "Back");
            return backUrl;
        }
        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    public String goForward() {
        if (canGoForward()) {
            backStack.push(currentPage);
            String forwardUrl = forwardStack.pop();
            showUrl(forwardUrl, "forward");
            return forwardUrl;
        }
        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }

    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }
}
