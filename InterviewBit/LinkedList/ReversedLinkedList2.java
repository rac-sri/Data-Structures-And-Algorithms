/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

  public ListNode reverseBetween(ListNode A, int B, int C) {
    ListNode head = A; // 1 2 3 4 5
    ListNode reverse = A;

    int nodeNumber = C - B;

    for (int x = 1; x < B - 1; x++) {
      reverse = reverse.next;
    }

    ListNode start = reverse;
    // start contains the leftside of the list

    if (nodeNumber == 0) {
      return head;
    }

    if (nodeNumber != 0) {
      reverse = reverse.next;

      // reverse is at the start of the reverse array

      for (int x = 1; x <= nodeNumber; x++) {
        reverse = reverse.next;
      }

      ListNode prev;

      if (B == 1) prev = reverse(start, nodeNumber); else {
        prev = reverse(start.next, nodeNumber);
      }

      if (B == 1) {
        start = prev;
        head = start;
      } else {
        start.next = prev;
      }
    }

    return head;
  }

  ListNode reverse(ListNode start, int nodeNumber) {
    ListNode prev = null;
    ListNode current = start;
    ListNode temp = start;
    ListNode next = null;

    while (nodeNumber-- >= 0) {
      //System.out.println(current.next.val);
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      if (nodeNumber == 0) {
        // ListNode(int x) { val = x; next = null; }
        // ListNode right = new ListNode
        // System.out.println(current.next.val + " " +prev.val + " " + temp.val);
        temp.next = current.next;
      }
    }

    return prev;
  }
}
