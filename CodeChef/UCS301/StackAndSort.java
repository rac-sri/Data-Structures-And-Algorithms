import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StackAndSort {

  public static void main(String[] args) {
    int n, i, x, y, a, b, temp;
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    Integer v[] = new Integer[n];
    for (i = 0; i < n; i++) {
      v[i] = sc.nextInt();
      s1.push(v[i]);
    }
    while (!s1.empty()) {
      if (s2.empty()) {
        s2.push(s1.peek());
        s1.pop();
      } else if (s2.peek() < s1.peek()) {
        a = s2.peek();
        b = s1.peek();
        if ((a < 10 && b < 10) && Math.abs(a - b) == 1) {
          s2.pop();
          s1.pop();
          s2.push(10 * Math.max(a, b) + Math.min(a, b));
        } else if (
          b > 9 &&
          a < 10 &&
          (Math.abs(a - b / 10) == 1 || Math.abs(a - b % 10) == 1)
        ) {
          x = b / 10;
          y = b % 10;
          s1.pop();
          s2.pop();
          s2.push(10 * Math.max(a, x) + Math.min(a, y));
        } else if (
          a > 9 &&
          b > 9 &&
          (Math.abs(a / 10 - b % 10) == 1 || Math.abs(b / 10 - a % 10) == 1)
        ) {
          s1.pop();
          s2.pop();
          s2.push(10 * Math.max(a / 10, b / 10) + Math.min(a % 10, b % 10));
        } else {
          s2.push(b);
          s1.pop();
        }
      } else if (s2.peek() > s1.peek()) {
        a = s1.peek();
        b = s2.peek();
        if (a < 10 && b < 10 && Math.abs(a - b) == 1) {
          s1.pop();
          s2.pop();
          s2.push(10 * b + a);
        } else if (a < 10 && b > 9 && a > b / 10) {
          s2.push(a);
          s1.pop();
        } else if (
          a < 10 &&
          b > 9 &&
          (Math.abs(a - b / 10) == 1 || Math.abs(a - b % 10) == 1)
        ) {
          x = b / 10;
          y = b % 10;
          s1.pop();
          s2.pop();
          s2.push(10 * Math.max(a, x) + Math.min(a, y));
        } else if (
          a > 9 &&
          b > 9 &&
          (Math.abs(a / 10 - b % 10) == 1 || Math.abs(b / 10 - a % 10) == 1)
        ) {
          s1.pop();
          s2.pop();
          s2.push(10 * Math.max(a / 10, b / 10) + Math.min(a % 10, b % 10));
        } else {
          temp = s1.peek();
          s1.pop();
          s1.push(s2.peek());
          s1.push(temp);
          s2.pop();
        }
      }
    }

    while (!s2.empty()) {
      System.out.print(s2.peek() + " ");
      s2.pop();
    }
    System.out.println();
    Arrays.sort(v, Collections.reverseOrder());

    for (i = 0; i < n; i++) {
      System.out.print(v[i] + " ");
    }
  }
}
