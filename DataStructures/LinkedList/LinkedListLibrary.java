import java.util.Scanner;

public class LinkedListLibrary {

  static class Node {
    int data;
    Node next;
  }

  static Node head;

  /**
   * insertion    O(n)
   * deletion     O(n)
   * updation     O(n)
   */

  static void insert(int value) {
    // Todo

    if (head == null) {
      Node temp = new Node();
      temp.data = value;
      head = temp;
    } else {
      Node temp = head;

      while (temp.next != null) {
        temp = temp.next;
      }

      Node newNode = new Node();
      newNode.data = value;
      temp.next = newNode;
    }
  }

  static void delete(int value) {
    // Todo

    if (head == null) return;

    Node temp = head;

    if (head.data == value) {
      head = head.next;
    }

    while (temp.next != null) {
      if (temp.next.data == value) {
        Node temp2 = temp.next.next;
        temp.next = temp2;
        continue;
      }

      temp = temp.next;
    }
  }

  static void update(int position, int value) {
    Node temp = head;

    for (int x = 1; x < position; x++) {
      if (temp.next == null) {
        break;
      }
      temp = temp.next;
    }

    temp.data = value;
  }

  static void print() {
    System.out.println("LinkedList : ");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  // driver code

  public static void main(String[] args) {
    System.out.println("Enter number of entries");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int x = 0; x < n; x++) {
      int entry = sc.nextInt();
      insert(entry);
    }

    print();

    System.out.println("Enter position and then the value to update");
    int position = sc.nextInt();
    int update = sc.nextInt();

    update(position, update);

    print();

    System.out.println("Enter value to delete");

    int delete = sc.nextInt();
    delete(delete);

    print();
  }
}
