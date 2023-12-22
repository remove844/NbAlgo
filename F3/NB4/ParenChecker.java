package F3.NB4;

import java.util.Stack;

public class ParenChecker {

    public ParenChecker() {
    }

    public boolean isBalances(String string){
        Boolean balanced = true;
        int index = 0;
        Stack stack = new Stack();

        while (index < string.length() && balanced) {
            char cNext = string.charAt(index);
            if (isOpen(cNext)) {
                stack.push(cNext);

            } else if (isClosed(cNext)) {
                if (stack.isEmpty()) return false;
                if(stack.peek().equals(isSame(cNext))) {
                    stack.pop();
                }else {
                    balanced = false;
                }
            }
            index++;
        }
        return balanced && stack.isEmpty();
    }

    private boolean isOpen(char c) {
        return c == '[' || c == '(' || c == '{';
    }
    private boolean isClosed(char c) {
        return c == ']' || c == ')' || c == '}';
    }
    private char isSame(char c) {
        if (c == ']') return '[';
        if (c == ')') return '(';
        if (c == '}') return '{';
        return '-';
    }


    public static void main(String[] args) {
        ParenChecker parenChecker = new ParenChecker();
        System.out.println(parenChecker.isBalances(("(w*(x+y)/z-(p/(r-q)))"))); // balanced
        System.out.println(parenChecker.isBalances(("(w*[x+y]/z-[p/{r-q}])"))); // balanced
        System.out.println(parenChecker.isBalances(("(w*[x+y)/z-[p/{r-q}])"))); // not balanced
    }
}
