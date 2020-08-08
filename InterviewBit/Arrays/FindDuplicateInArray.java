/**
 * Amazon vmware riverbed : 440/450
 */

public class Solution {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int repeatedNumber(final int[] A) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    int number = -1;
    for (int x = 0; x < A.length; x++) {
      Integer value = hash.get(A[x]);
      if (value != null) {
        number = A[x];
        break;
      } else {
        hash.put(A[x], 1);
      }
    }

    return number;
  }
}
