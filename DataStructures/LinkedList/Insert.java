import java.util.Scanner;

public class Insert {

  static class Node {
    int data;
    Node next;
  }

  public static void main(String[] args) {
    System.out.println(
      "Insert the number of values you want to add to the linked List and then input new values one by one"
    );

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // inputing value
    Node pointer = new Node();
    Node head = pointer;
    int value2 = sc.nextInt();
    pointer.data = value2;

    for (int x = 1; x < n; x++) {
      int value = sc.nextInt();
      Node newdata = new Node();
      newdata.data = value;
      newdata.next = null; // optional
      pointer.next = newdata;
      pointer = pointer.next;
    }

    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }
}
