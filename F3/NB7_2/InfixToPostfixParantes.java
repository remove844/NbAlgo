package F3.NB7_2;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class InfixToPostfixParantes {
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    private Stack<Character> operatorStack= new Stack<>();
    private Stack<Integer> counterStack = new Stack<>();
    private static final String OPERATORS = "+-*/()";
    private static final int[] PRECEDENCE = {1 ,1, 2, 2, -1, -1};
    private StringBuilder postfix = new StringBuilder();

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }
    private int precedence(char op){
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    public String convert(String infix) throws SyntaxErrorException {
        try {
            Scanner scan = new Scanner(infix);
            String nextToken;
            while ((nextToken = scan.findInLine("[\\p{L}\\p{N}]+|[-+/\\*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
                }
            }
            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                if (op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                }
                postfix.append(op);
                postfix.append(' ');
            }
            return postfix.toString();
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private void processOperator(char op) {
        if (operatorStack.empty() || op == '(') {
            operatorStack.push(op);
        } else {
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {
                while (!operatorStack.empty() && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    if (topOp == '(') {
                        break;
                    }
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }
                }
                if (op != ')') {
                    operatorStack.push(op);
                }
            }
        }
    }

    public static void main(String[] args) throws SyntaxErrorException {
        InfixToPostfixParantes infixToPostfix = new InfixToPostfixParantes();

        System.out.println("Result: " + infixToPostfix.convert("8 ( 4 + 2 ) + 3 * ( 3 - (2 - 1))"));


    }


}
