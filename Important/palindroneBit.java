// 2^((l-1)/2) number of items in a group
// A << x is equal to multiplication by pow(2, x). Think why. 1 << x is equal to pow(2, x).

public class Solution {

  public int solve(int A) {
    int count = 1;
    int len = 1;

    while (count < A) {
      len++;
      int elementsForThisLen = (1 << (len - 1) / 2);
      count += elementsForThisLen;
    }

    count -= (1 << (len - 1) / 2); // removing last entry, now I am at the begining of the group to which the element belongs

    int offSet = A - count - 1; //found position offset

    int ans = (1 << (len - 1));
    ans |= (offSet << (len / 2)); // len/2 since if the length is for eg 8, then first 4 are unique ( palindrome)

    int valForReverse = (ans >> (len / 2)); // for getting nor reveresed right side

    int rev = getRev(valForReverse);

    ans |= rev;

    return ans;
  }

  public static int getRev(int valForReverse) {
    int rev = 0;

    while (valForReverse != 0) {
      int lowestBit = (valForReverse & 1);
      rev |= lowestBit;
      rev <<= 1;
      valForReverse >>= 1;
    }
    rev >>= 1;
    return rev;
  }
}
