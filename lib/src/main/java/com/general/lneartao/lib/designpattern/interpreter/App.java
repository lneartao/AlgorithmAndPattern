package com.general.lneartao.lib.designpattern.interpreter;

import com.general.lneartao.lib.Logger;

import java.util.Stack;

/**
 * Created by lneartao on 2017/12/8.
 */

public class App {
    public static void main(String[] args) {
        String tokenString = "4 3 2 - 1 + *";
        Stack<Expression> stack = new Stack<>();

        String[] tokenList = tokenString.split(" ");
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Logger.printl("popped form stack left: " + leftExpression.interpret() + " right: " + rightExpression.interpret());
                Expression operator = getOperatorInstance(s, leftExpression, rightExpression);
                Logger.printl("operator: " + operator);
                int result = operator.interpret();
                NumberExpression resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                Logger.printl("push result to stack: " + resultExpression.interpret());
            } else {
                Expression i = new NumberExpression(s);
                stack.push(i);
                Logger.printl("push to stack: " + i.interpret());
            }
        }
        Logger.printl("result: " + stack.pop().interpret());
    }

    public static boolean isOperator(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s);
    }

    /**
     * Get expression for string
     */
    public static Expression getOperatorInstance(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            default:
                return new MultiplyExpression(left, right);
        }
    }
}
