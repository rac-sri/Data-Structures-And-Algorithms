import java.io.*;
import java.util.*;

public class maximumElement {

    static class ObjectStack {
        int val;
        int max;

        public ObjectStack(int val, int max) {
            this.val = val;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        Stack<ObjectStack> stack = new Stack<ObjectStack>();

        while (n > 0) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int val = sc.nextInt();
                    max = Math.max(val, max);
                    stack.push(new ObjectStack(val, max));
                    break;
                case 2:
                    if (!stack.isEmpty())
                        stack.pop();
                    max = stack.isEmpty() ? 0 : stack.peek().max;
                    break;
                case 3:
                    if (!stack.isEmpty())
                        System.out.println(stack.peek().max);
            }
            n--;
        }
    }
}
