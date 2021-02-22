/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode A) {
        if(A.next == null){
            return A;
        }
       ListNode head = A.next;
       ListNode start = null;
        
        while(A!=null && A.next !=null){
            ListNode a1 = A; // 23
            ListNode a2 = A.next; // 242
            ListNode next = a2.next; // 21
            
            a2.next = a1; // 242 -> 23
            a1.next = next;  // 23 -> 21
            
            if(start != null){
                start.next = a2;
            }
            
           
            start = a1;
            A = a1.next;
        
        }
        
        return head;
    }

}
