/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

// String approach , not working for values > range of long

// public class Solution {
//     public ListNode addTwoNumbers(ListNode A, ListNode B) {

//         String a = ""; String b="";

//         while(A != null){
//             a = a + A.val;
//             A = A.next;
//         }

//         while(B != null){
//             b = b+ B.val;
//             B = B.next;
//         };

//         String aa = new StringBuilder(a).reverse().toString();
//         String bb = new StringBuilder(b).reverse().toString();

//         String c = new StringBuilder(String.valueOf(Long.parseLong(aa) + Long.parseLong(bb))).reverse().toString();

//         ListNode start = new ListNode(c.charAt(0) - '0');
//         ListNode pointer = start;

//         for(int x = 1;x < c.length();x++){
//              ListNode temp = new ListNode(c.charAt(x)- '0');
//              pointer.next = temp;
//              pointer = pointer.next;
//         }

//         return start;
//     }

// }

public class Solution {

  public ListNode addTwoNumbers(ListNode A, ListNode B) {
    ListNode templist = null;
    ListNode head = null;
    int carry = 0;
    int value = 0;
    while (A != null || B != null) {
      if (A == null && B != null) {
        if (B.val + carry > 9) {
          carry = 1;
          value = 0;
        } else {
          value = B.val + carry;
          carry = 0;
        }
        B = B.next;
      } else if (A != null && B == null) {
        if (A.val + carry > 9) {
          carry = 1;
          value = 0;
        } else {
          value = A.val + carry;
          carry = 0;
        }
        A = A.next;
      } else {
        if (A.val + B.val + carry > 9) {
          value = (A.val + B.val + carry) % 10;
          carry = 1;
        } else {
          value = A.val + B.val + carry;
          carry = 0;
        }
        A = A.next;
        B = B.next;
      }
      if (templist == null) {
        templist = new ListNode(value);
        head = templist;
      } else {
        templist.next = new ListNode(value);
        templist = templist.next;
      }
      if (A == null && B == null && carry == 1) {
        templist.next = new ListNode(carry);
        templist = templist.next;
      }
    }
    return head;
  }
}
