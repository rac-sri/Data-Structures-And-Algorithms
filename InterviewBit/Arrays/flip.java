// You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

// Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

// Notes:

// Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
// For example,

// S = 010

// Pair of [L, R] | Final string
// _______________|_____________
// [1 1]          | 110
// [1 2]          | 100
// [1 3]          | 101
// [2 2]          | 000
// [2 3]          | 001

// We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return empty array.

// ******************************
// First Look Approach -> find maximum zeros, then move right and left, check if total zeros are still more.
// And then add them to the max zero. Keep track of all the entries.
// ******************************
// public class Solution {

//     class Pairs {
//         int first;
//         int second;

//         Pairs(){
//             first = Integer.MIN_VALUE;
//         }
//         Pairs(int a , int b){
//             first = a;
//             second = b;
//         }
//     }

//     Pairs pair = new Pairs();

//     public ArrayList<Integer> flip(String A) {
//         int max = maxZero(A);

//         // left
//         int leftIncrement = leftIncrement(A);
//         // right
//         int rightIncrement = rightIncrement(A);

//         if(leftIncrement > 0 && rightIncrement > 0){
//             max += leftIncrement + rightIncrement;
//         }
//         else if(leftIncrement > 0 ){
//             max += leftIncrement;
//         }
//         else if(rightIncrement > 0){
//             max += rightIncrement;
//         }

//         ArrayList<Integer> list = new ArrayList<Integer>();
//         list.add(pair.first , pair.second);

//         return list;
//     }

//     public int leftIncrement(String A){
//         int leftPosition = this.pair.first;
//         int newZeros = 0;
//         if(leftPosition > 0){
//             for(int x=leftPosition; x>-1; x--){
//                 if(A.charAt(x) == '0'){
//                     newZeros += 1;
//                 }
//                 else
//                     newZeros -= 1;
//             }
//         }
//         return newZeros;
//     }

//         public int rightIncrement(String A){
//         int rightPosition = this.pair.second;
//         int newZeros = 0;

//             for(int x=rightPosition; x<A.length(); x++){
//                 if(A.charAt(x) == '0'){
//                     newZeros += 1;
//                 }
//                 else
//                     newZeros -= 1;
//             }

//         return newZeros;
//     }

//     public int maxZero(String A){
//         int count = 0;
//         int max = 0;
//         Pairs temp = new Pairs(-1 , -1);

//         for(int x = 0;x<A.length();x++){
//             if(A.charAt(x) == '0'){
//                 if(temp.first == -1){
//                     pair.first = x;
//                 }
//                 count+=1;
//             }
//             else{
//                 if(pair.second == -1){
//                     pair.second = x-1;
//                 }
//                 if(count > max){
//                     max = count;
//                     temp.first = -1;
//                     temp.second = -1;
//                 }
//             }
//         }

//         this.pair.first = temp.first;
//         this.pair.second = temp.second;

//         return max;
//     }
// }

// ********** Working approach using Kadane's algorithm ***************

public class Solution {
  private int maxCount = 0;
  private int left = -1;
  private int right = -1;
  private boolean reset = true;

  public ArrayList<Integer> flip(String A) {
    int count = 0;
    int curLeft = 0;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '0') {
        if (reset) {
          curLeft = i;
          reset = false;
        }
        count++;
      } else {
        if (count > maxCount) {
          maxCount = count;
          left = curLeft + 1;
          right = i;
        }
        if (count > 0) {
          count--;
        } else {
          count = 0;
          reset = true;
        }
      }
    }
    if (count > maxCount) {
      maxCount = count;
      left = curLeft + 1;
      right = A.length();
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    if (right > -1) {
      list.add(left);
      list.add(right);
    }

    return list;
  }
}
