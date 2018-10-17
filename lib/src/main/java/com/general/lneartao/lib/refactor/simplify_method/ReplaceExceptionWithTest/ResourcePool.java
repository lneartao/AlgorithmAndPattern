package com.general.lneartao.lib.refactor.simplify_method.ReplaceExceptionWithTest;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class ResourcePool {

    Stack<Resource> available;
    Stack<Resource> allocated;

    Resource getResource() {
        Resource result;
        try {
            result = available.pop();
            allocated.push(result);
            return result;
        } catch (EmptyStackException e) {
            result = new Resource();
            allocated.push(result);
            return result;
        }
    }
}
