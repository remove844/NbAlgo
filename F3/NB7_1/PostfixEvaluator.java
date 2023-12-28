package F3.NB7_1;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    private static final String OPERATORS = "+-*/";
    private static final int[] PRECEDENCE = {1 ,1, 2, 2};
    private Stack<Integer> counterStack = new Stack<>();
    private Stack<Character> operandStack = new Stack<>();
    private StringBuilder postfix = new StringBuilder();

    private int evalOp(char op) {
        if(counterStack.size() < 2) throw new EmptyStackException();
        int value = counterStack.pop();
        int value2 = counterStack.pop();
        int result = 0;
        if(op == '+') result = value2 + value;
        if(op == '-') result = value2 - value;
        if(op == '*') result = value2 * value;
        if(op == '/') result = value2 / value;
        return counterStack.push(result);
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    private int precedence(char op){
    return PRECEDENCE[OPERATORS.indexOf(op)];
    }
    public int eval(String expression) throws SyntaxErrorException {
        counterStack = new Stack<>();
        String[] tokens = expression.split(" +");
        int result;
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    counterStack.add(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    evalOp(nextToken.charAt(0));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }

            result = counterStack.pop();
            if(!counterStack.isEmpty()) throw new SyntaxErrorException("Stack not empty");
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
        return result;
    }

    public String convert(String infix) throws SyntaxErrorException {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        postfix.setLength(0);
        try {
            String nextToken;
            Scanner scan = new Scanner(infix);
            while ((nextToken = scan.findInLine("[\\p{L}\\p{N}]+|[-+/\\*()]")) != null) {
                char firstChar = nextToken.charAt(0);
                if (Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar)) {
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar, operatorStack);
                } else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
                }
            }
            while (!operatorStack.isEmpty()) {
                char op = operatorStack.pop();
                if ((op) == '(') throw new SyntaxErrorException("unmatched opening paranthesis");
                postfix.append(op);
                postfix.append(' ');
            }
            return postfix.toString();
        }catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }


    private void processOperator(char op, Stack<Character> operatorStack) throws SyntaxErrorException {
        if(operatorStack.isEmpty() || op == '('){
            operatorStack.push(op);
        }else {
            char topOp = operatorStack.peek();
            if(precedence(op) > precedence(topOp)){
                operatorStack.push(op);
            }else {
                while (!operatorStack.empty() && precedence(op) <= precedence(topOp)){
                    if(topOp == '(') {
                        break;
                    }
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if(!operatorStack.empty()){
                        topOp = operatorStack.peek();
                    }
                }
                if (op != ')') {
                    operatorStack.push(op);
                } else {
                    if (!operatorStack.isEmpty() && topOp == '(') {
                        operatorStack.pop();
                    } else {
                        throw new SyntaxErrorException("Unmatched closing parenthesis");
                    }
                }
            }
        }
    }



    public static void main(String[] args) throws SyntaxErrorException {
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();

        System.out.println(postfixEvaluator.convert("12 6 + 3 /"));
        System.out.println(postfixEvaluator.eval("12 6 + 3 /"));




    }

}
