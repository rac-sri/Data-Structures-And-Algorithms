// Sorted Permutation Rank
// Asked in:
// Housing
// Zenefits
// Microsoft
// Given a string, find the rank of the string amongst its permutations sorted lexicographically.
// Assume that no characters are repeated.

// Example :

// Input : 'acb'
// Output : 2

// The order permutations with letters 'a', 'c', and 'b' :
// abc
// acb
// bac
// bca
// cab
// cba
// The answer might not fit in an integer, so return your answer

// first
public class Solution {

  static long fact(int n) {
    return (n <= 1) ? 1 : n * fact(n - 1);
  }

  // A utility function to count smaller
  // characters on right of arr[low]
  static int findSmallerInRight(String str, int low, int high) {
    int countRight = 0, i;

    for (i = low + 1; i <= high; ++i) if (
      str.charAt(i) < str.charAt(low)
    ) ++countRight;

    return countRight;
  }

  // A function to find rank of a string in
  // all permutations of characters
  static int findRank(String str) {
    int len = str.length();
    long mul = fact(len);
    int rank = 1;
    long countRight;

    for (int i = 0; i < len; ++i) {
      mul /= len - i;
      //System.out.println(mul);
      // count number of chars smaller
      // than str[i] from str[i+1] to
      // str[len-1]
      countRight = findSmallerInRight(str, i, len - 1);

      //rank += ((int)(countRight * mul))%1000003;
      rank = (int) (rank + (countRight * mul) % 1000003) % 1000003;
    }

    return rank % 1000003;
  }
}
