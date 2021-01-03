/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public static ListNode insertionSortList(ListNode A) {
          ListNode curr = A;
          ListNode temp;
          ListNode prev;
          ListNode node;
  
          while(curr.next != null) {
              if(curr.next != null && curr.val > curr.next.val) {
                  prev = null;
                  temp = A;
                  node = curr.next; // This node is to be inserted in it's correct position
                  curr.next = curr.next.next;
                  while(temp != null && temp.val <= node.val) { //Move forward for every value less than or equal to node's value because insertion sort is stable sort
                      prev = temp;
                      temp = temp.next;
                  }
                  if(prev == null ) { // Prev will be null if any value less than head value is at right side 
                      node.next = temp;
                      A = node; // New head
                  } else { // Otherwise it will point to the last node less than node's value
                      node.next = prev.next;
                      prev.next = node;
                  }
              } else {
                  curr = curr.next;
              }
          }
          return A;
      }
  }
  