/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {

  public ListNode mergeKLists(ArrayList<ListNode> a) {
    ListNode head = a.get(0);

    for (int x = 1; x < a.size(); x++) {
      ListNode list2 = a.get(x);
      head = mergeLists(head, list2);
    }

    return head;
  }

  public ListNode mergeLists(ListNode list1, ListNode list2) {
    int i = 0;
    int j = 0;
    ListNode head;

    if (list1.val < list2.val) {
      head = new ListNode(list1.val);
      list1 = list1.next;
    } else {
      head = new ListNode(list2.val);
      list2 = list2.next;
    }

    ListNode ret = head;
    while (true) {
      if (list1 == null || list2 == null) break;
      if (list1.val < list2.val) {
        head.next = new ListNode(list1.val);
        head = head.next;
        list1 = list1.next;
      } else {
        head.next = new ListNode(list2.val);
        head = head.next;
        list2 = list2.next;
      }
    }

    while (list1 != null) {
      head.next = new ListNode(list1.val);
      head = head.next;
      list1 = list1.next;
    }
    while (list2 != null) {
      head.next = new ListNode(list2.val);
      head = head.next;
      list2 = list2.next;
    }

    return ret;
  }
}
