public class Solution {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int strStr(final String txt, final String pat) {
    int M = pat.length();
    int N = txt.length();

    int lps[] = new int[M];
    int j = 0;
    int position = -1;

    // calculate the lps array
    computeLPSArray(pat, M, lps);

    int i = 0;

    while (i < N) {
      if (pat.charAt(j) == txt.charAt(i)) {
        j++;
        i++;
      }

      if (j == M) {
        position = (i - j);
        j = lps[j - 1];
        break;
      } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
        if (j != 0) {
          j = lps[j - 1];
        } else {
          i = i + 1;
        }
      }
    }
    return position;
  }

  void computeLPSArray(String pat, int M, int lps[]) {
    int len = 0; // length of the previous longest prefix suffix
    int i = 1;
    lps[0] = 0;

    while (i < M) {
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }
  }
}
