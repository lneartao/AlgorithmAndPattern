package com.general.lneartao.lib.refactor.simplify_method.ReplaceExceptionWithTest;

import java.util.Stack;

/**
 * 以测试取代异常：修改调用者，使它在调用函数之前先做检查
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class ResourcePool {

    Stack<Resource> available;
    Stack<Resource> allocated;

    Resource getResource() {
        Resource result;
        if (available.empty()) {
            result = new Resource();
        } else {
            result = available.pop();
        }
        allocated.push(result);
        return result;
    }
}
