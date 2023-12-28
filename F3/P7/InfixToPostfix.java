package F3.P7;

import java.util.EmptyStackException;
import java.util.Stack;

public class InfixToPostfix {
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    private Stack<Character> operatorStack= new Stack<>();
    private Stack<Integer> counterStack = new Stack<>();
    private static final String OPERATORS = "+-*/";
    private static final int[] PRECEDENCE = {1 ,1, 2, 2};
    private StringBuilder postfix = new StringBuilder();

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }
    private int precedence(char op){
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    public int eval(String expression) throws SyntaxErrorException {
        String[] tokens = expression.split(" +");
        int result = 0;
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

    private int evalOp(char op) {
        if(counterStack.isEmpty()) throw new EmptyStackException();
        int val1 = counterStack.pop();
        int val2 = counterStack.pop();
        int counter = switch (op) {
            case '+' -> val2 + val1;
            case '*' -> val2 * val1;
            case '/' -> val2 / val1;
            case '-' -> val2 - val1;
            default -> -1;
        };
        return counterStack.push(counter);
    }

    public int convert(String infix) throws SyntaxErrorException {
        String[] tokens = infix.split("\\s+");
        String temp = "+";
        try{
            for(String nextToken : tokens){
                char firstChar = nextToken.charAt(0);
                if(Character.isJavaIdentifierStart(firstChar) || Character.isDigit(firstChar) ){
                    if(!isOperator(temp.charAt(0))) throw new SyntaxErrorException("Wrong order");
                    postfix.append(nextToken);
                    postfix.append(' ');
                } else if (isOperator(firstChar)) {
                    if(!Character.isDigit(temp.charAt(0)))throw new SyntaxErrorException("Wrong order");
                    processOperator(firstChar);
                }else {
                    throw new SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
                }
                temp = nextToken;
            }
            while (!operatorStack.empty()){
                char op = operatorStack.pop();
                postfix.append(op);
                postfix.append(' ');
            }
            System.out.println("In postfix: " + postfix.toString());
            return eval(postfix.toString());
        }catch (EmptyStackException ex){
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }
    private void processOperator(char op) {
        if (operatorStack.empty()) {
            operatorStack.push(op);
        } else {
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {
                while (!operatorStack.empty() && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    postfix.append(topOp);
                    postfix.append(' ');
                    if (!operatorStack.empty()) {
                        topOp = operatorStack.peek();
                    }
                }
                operatorStack.push(op);
            }
        }
    }

    public static void main(String[] args) throws SyntaxErrorException {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println("Result: " + infixToPostfix.convert("8 + 9"));
    }


}
