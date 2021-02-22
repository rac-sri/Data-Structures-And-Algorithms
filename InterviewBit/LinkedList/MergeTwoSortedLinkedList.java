/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = null;
        ListNode C = null;
        if(A.val < B.val){
                ListNode temp = new ListNode (A.val);
                C  = temp;
                A = A.next;
        } else{
            ListNode temp = new ListNode (B.val);
                C = temp;
                B = B.next;
            } 
        
       
        head = C;
        
        while(A != null || B != null){
          
          if(A != null && B != null){
                //  System.out.println(A.val + " " + B.val);
            if(A.val < B.val){
                ListNode temp = new ListNode (A.val);
                C.next = temp;
                A = A.next;
                
            }
            else  {
            ListNode temp = new ListNode (B.val);
                C.next = temp;
                B = B.next;
            } 
          
          }
          else if( A!=null){
              C.next = A;
              A = A.next;
              
          }
          else {
              C.next = B;
              B = B.next;
           
          }
            C = C.next;
        
        }
        
        
        return head;
    }
}
