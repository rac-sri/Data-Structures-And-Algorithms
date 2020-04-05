import java.io.*;
import java.util.*;

public class simpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        long n = sc.nextInt();
        String str = "";
        while (n-- > 0) {
            int qr = sc.nextInt();
            String s = "";
            if (qr != 4)
                s = sc.nextLine();
            switch (qr) {
                case 1:
                    str += s.trim();
                    stack.push(str);
                    break;
                case 2:
                    int no = Integer.parseInt(s.trim());
                    str = str.substring(0, str.length() - no);
                    stack.push(str);
                    break;
                case 3:
                    int np = Integer.parseInt(s.trim());
                    System.out.println(str.charAt(np - 1));
                    break;
                case 4:
                    if (!stack.isEmpty()) {
                        stack.pop();
                        if (!stack.isEmpty())
                            str = stack.peek();
                    }
                    break;
            }
        }
    }

}