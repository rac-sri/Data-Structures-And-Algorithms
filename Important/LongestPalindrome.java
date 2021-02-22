public class Solution {

  public String longestPalindrome(String s) {
    int n = s.length();
    int palindromeBeginsAt = 0;
    int maxLen = 1;
    boolean palindrome[][] = new boolean[n][n];

    /**
     *      a b c d e f
     *     a
     *     b
     *     c
     *     d
     *     e
     *     f           not we interate and check for different lengths
     **/

    // Trivial case: single case letter palindromes
    for (int i = 0; i < n; i++) {
      palindrome[i][i] = true;
    }

    // finding palindromes of two number

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        palindrome[i][i + 1] = true;
        palindromeBeginsAt = i;
        maxLen = 2;
      }
    }

    // finding palindromes of length 3 to n and savind the longest
    for (int currLen = 3; currLen <= n; currLen++) {
      for (int i = 0; i < n - currLen + 1; i++) {
        int j = i + currLen - 1;
        if (s.charAt(i) == s.charAt(j) && palindrome[i + 1][j - 1]) {
          palindrome[i][j] = true;
          if (maxLen < currLen) {
            palindromeBeginsAt = i;
            maxLen = currLen;
          }
        }
      }
    }

    //System.out.println(palindromeBeginsAt + " " + maxLen);
    return s.substring(palindromeBeginsAt, palindromeBeginsAt + maxLen);
  }
}
