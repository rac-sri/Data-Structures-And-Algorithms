// public class Solution {
//     // DO NOT MODIFY THE LIST. IT IS READ ONLY
//     public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

//         Queue<Integer> queue = new PriorityQueue<Integer>(
//              new Comparator<Integer>() {
//                     public int compare(Integer a, Integer b)
//                     {
//                         if (a < b)
//                             return 1;
//                         if (a > b)
//                             return -1;
//                         return 0;
//                     }
//                 }
//             );

//         ArrayList<Integer> max = new ArrayList<Integer>();
//         int count = 0;
//         if(B<= A.size()){

//             // fill k values into queue
//             while(count<=B){
//                 //System.out.println(A.get(count));
//                 queue.add(A.get(count));
//                 count++;
//             }

//             // now we have queue filled with elements with length k and also the max amount them

//             // now pop one and push one while checking the max no.

//             for(int x = ++count;x<A.size();x++){
//                 int pop = queue.poll();
//                 max.add(pop);
//                 queue.add(A.get(count));
//             }

//              int pop = queue.poll();
//                 max.add(pop);
//                 return max;
//         }

//         else {

//             while(++count < A.size()){
//                 queue.add(A.get(count));
//             }

//             int pop = queue.poll();
//              max.add(pop);
//              return max;
//         }
//     }
// }

public class Solution {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    int n = A.size();

    if (B <= 0 || A == null || n == 0) {
      return new ArrayList<>();
    }

    ArrayList<Integer> ans = new ArrayList<>();

    int i = 0;
    int j = 0;
    //Deque to store previous Max before sliding window to next block
    Deque<Integer> dq = new ArrayDeque<>();

    while (j < n) {
      while (!dq.isEmpty() && A.get(dq.peekLast()) <= A.get(j)) {
        dq.removeLast();
      }
      dq.addLast(j);

      if (j - i + 1 < B) {
        j++;
      } else if (j - i + 1 == B) {
        if (!dq.isEmpty() && dq.peekFirst() < i) dq.removeFirst();
        ans.add(A.get(dq.peekFirst()));
        j++;
        i++;
      }
    }
    return ans;
  }
}
