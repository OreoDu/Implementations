package DataStructure;

import java.util.Objects;
import java.util.Stack;

public class EvaluationStack {
    public static void main(String[] args) {
        SLListStack<Integer> numQueue = new SLListStack<>();
        SLListStack<Character> opeQueue = new SLListStack<>();
        for (char c: args[0].toCharArray()) {
            if (c == '(') continue;
            else if (Character.isDigit(c)) numQueue.push(Character.getNumericValue(c));
            else if (c == '*' || c == '+' || c == '/' || c == '-') opeQueue.push(c);
            else if (c == ')') {
                char ope = opeQueue.pop();
                int num0 = numQueue.pop();
                int num1 = numQueue.pop();
                if (ope == '*') numQueue.push(num1 * num0);
                else if (ope == '/') numQueue.push(num1 / num0);
                else if (ope == '+') numQueue.push(num1 + num0);
                else if (ope == '-') numQueue.push(num1 - num0);
            }
        }
        System.out.println("The result of the expression is: " + numQueue.pop());
    }
}
