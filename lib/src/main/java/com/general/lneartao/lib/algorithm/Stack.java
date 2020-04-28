package com.general.lneartao.lib.algorithm;

/**
 * @author lneartao
 * @date 2020/4/27.
 */
public class Stack {

    public static void main(String[] args) {
//        testIsValid();
        testEvalRPN();
    }

    private static void testIsValid() {
        System.out.println(isValid("]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("(){"));
        System.out.println(isValid("({)"));
        System.out.println(isValid("({})"));
        System.out.println(isValid("(]"));
    }

    private static void testEvalRPN() {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10",
                                                "6",
                                                "9",
                                                "3",
                                                "+",
                                                "-11",
                                                "*",
                                                "/",
                                                "*",
                                                "17",
                                                "+",
                                                "5",
                                                "+"}));
    }

    /**
     * 有效括号
     * https://leetcode-cn.com/problems/valid-parentheses/
     *
     * @param s
     *
     * @return
     */
    public static boolean isValid(String s) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        char[] stack = new char[s.length()];
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack[cur++] = curChar;
            } else {
                if (cur == 0) {
                    return false;
                }
                char curCharLeft = stack[--cur];
                switch (curChar) {
                    case ')':
                        if (curCharLeft != '(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (curCharLeft != '{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (curCharLeft != '[') {
                            return false;
                        }
                        break;
                    default:
                }
            }
        }
        return cur == 0;
    }

    /**
     * 逆波兰表达式求值
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
     *
     * @param tokens
     *
     * @return
     */
    public static int evalRPN(String[] tokens) {
        java.util.Stack<Integer> numStack = new java.util.Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default:
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        return numStack.pop();
    }

}
