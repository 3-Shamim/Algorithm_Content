package main;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your input type:\n" + "1. For console input: \n" + "2. For file input:");
        int type = scanner.nextInt();
        scanner.nextLine();
        switch (type) {
            case 1: {
                switch (conversionType(scanner)) {
                    case 1: {
                        System.out.println("Enter your infix expression:");
                        scanner.nextLine();
                        String infix = scanner.nextLine();
                        System.out.println("Prefix:");
                        System.out.println(infixToPrefix(infix));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter your infix expression:");
                        scanner.nextLine();
                        String infix = scanner.nextLine();
                        System.out.println("Postfix:");
                        System.out.println(infixToPostfix(infix));
                        break;
                    }
                    default:
                        System.out.println("Enter a valid input.txt.");
                }
                break;
            }
            case 2: {
                File file = new File("input.txt");
                if (file.exists()) {
                    getInfixExpressionFromFileAndConvert(scanner);
                } else {
                    System.out.println("input.txt file not exist. Please create your input.txt file in root path.");
                }
                break;
            }
            default:
                System.out.println("Enter a valid input.txt.");

        }

        scanner.close();
    }

    private void getInfixExpressionFromFileAndConvert(Scanner scanner) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("input.txt", "r")) {
            if (randomAccessFile.length() != 0) {
                switch (conversionType(scanner)) {
                    case 1: {
                        String infix;
                        System.out.println("Prefix:");
                        while ((infix = randomAccessFile.readLine()) != null) {
                            System.out.println(infixToPrefix(infix));
                        }
                        break;
                    }
                    case 2: {
                        String infix;
                        System.out.println("Postfix:");
                        while ((infix = randomAccessFile.readLine()) != null) {
                            System.out.println(infixToPostfix(infix));
                        }
                        break;
                    }
                    default:
                        System.out.println("Enter a valid input.txt.");
                }
            } else {
                System.out.println("There is no expression in your file. Please enter an infix expression.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int conversionType(Scanner scanner) {
        System.out.println("1. Infix to Prefix:\n" + "2. Infix to Postfix:");
        return scanner.nextInt();
    }

    private String infixToPrefix(String infix) {
        String reverse = reverseString(infix);
        String postfix = infixToPostfix(reverse);
        return reverseString(postfix);
    }

    private String reverseString(String infix) {
        String result = "";
        for (int i = infix.length() - 1; i >= 0; i--) {
            if (infix.charAt(i) == '(' || infix.charAt(i) == ')') {
                if (infix.charAt(i) == '(') result += ")";
                else if (infix.charAt(i) == ')') result += "(";
            } else {
                result += charToString(infix.charAt(i));
            }
        }
        return result;
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
        try {
            new Main();
        } catch (Exception e) {
            System.out.println("Please Enter Valid Input. Input not match. Please take help from input.txt above text.");
        }
    }

    enum Priority {
        DEFAULT, SAME, LOW, HIGH
    }

}
