import java.util.*;

class JesseAndCookies {

  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    Scanner sc = new Scanner(System.in);
    int loop = sc.nextInt();
    int minimum = sc.nextInt();

    while (loop-- > 0) {
      int n = sc.nextInt();
      pq.add(n);
    }
    int count = 0;
    int next = pq.peek();
    while (next < minimum) {
      int first = pq.poll();
      int second = pq.poll();
      int third = (1 * first) + (2 * second);
      pq.add(third);
      if (pq.size() > 1) {
        next = pq.peek();
        count++;
      } else if (pq.peek() > minimum) {
        System.out.print("dsajkhdkj");
        count++;
        break;
      } else {
        count = -1;
        break;
      }
    }
    System.out.println(count);
  }
}
