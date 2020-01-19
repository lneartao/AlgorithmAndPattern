package com.general.lneartao.lib.effectivejava.r5;

import java.util.EnumSet;
import java.util.Set;

/**
 * 用EnumSet代替位域
 * <p>
 * EnumSet的缺点在于它无法创建不可变的EnumSet
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class I36 {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void applyStyles(int styles) {

    }

    // 更好的实现方式
    public void applyStyles(Set<Style> styles) {

    }

    public static void main(String[] args) {
        new I36().applyStyles(STYLE_BOLD | STYLE_ITALIC);
        new I36().applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
