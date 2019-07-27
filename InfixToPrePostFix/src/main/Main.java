package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: 7/27/19
 * Time: 9:45 PM
 * Mail: mdshamim732@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

public class Main {

    public Main() {
//        String infix = "(A*B)+(C/D)";
//        String infix = "A*(B+C)/D";
        String infix = "A*(B+C/D)";
        System.out.println(infix);
        System.out.println(infixToPostfix(infix));
    }

    private String infixToPostfix(String infix) {

        Stack<String> stack = new Stack<>();
        StringBuilder expression = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            if (isOperator(infix.charAt(i))) {
                if (charToString(infix.charAt(i)).equals(")")) addOperatorInExpressionFromBracket(stack, expression);
                else addOperatorInExpression(stack, expression, charToString(infix.charAt(i)));
            } else {
                expression.append(charToString(infix.charAt(i)));
            }
        }

        while (!stack.empty()) {
            expression.append(stack.pop());
        }

        return expression.toString();
    }

    private void addOperatorInExpressionFromBracket(Stack<String> stack, StringBuilder expression) {
        String item;
        while (!(item = stack.pop()).equals("(")) {
            expression.append(item);
        }
    }

    private void addOperatorInExpression(Stack<String> stack, StringBuilder expression, String operator) {
        if (isHigherOperator(stack, operator) == Priority.DEFAULT) {
            stack.push(operator);
        } else {
            if (isHigherOperator(stack, operator) == Priority.SAME) {
                expression.append(stack.pop());
                stack.push(operator);
            } else {
                if (isHigherOperator(stack, operator) == Priority.LOW) {
                    String pop = stack.pop();
                    expression.append(pop);
                    addOperatorInExpression(stack, expression, operator);
                } else {
                    stack.push(operator);
                }
            }
        }
    }

    private Priority isHigherOperator(Stack<String> stack, String operator) {

        if (stack.empty()) return Priority.DEFAULT;

        if (stack.peek().equals("(") || operator.equals("(")) return Priority.DEFAULT;

        return compareOperatorPriority(stack.peek(), operator);
    }

    private Priority compareOperatorPriority(String s1, String s2) {
        Map<String, Integer> operatorWithPriority = new HashMap<>();
        operatorWithPriority.put("-", 1);
        operatorWithPriority.put("+", 1);
        operatorWithPriority.put("*", 2);
        operatorWithPriority.put("/", 2);
        operatorWithPriority.put("^", 3);

        if (operatorWithPriority.get(s1).equals(operatorWithPriority.get(s2))) return Priority.SAME;

        if (operatorWithPriority.get(s1) > operatorWithPriority.get(s2)) {
            return Priority.LOW;
        } else {
            return Priority.HIGH;
        }
    }

    private String charToString(char c) {
        return String.valueOf(c);
    }

    private boolean isOperator(char c) {
        switch (c) {
            case '(':
            case ')':
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Main();
    }

    enum Priority {
        DEFAULT, SAME, LOW, HIGH
    }

}
