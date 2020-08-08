// You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

// If so, return the integer. If not, return -1.

// If there are multiple solutions, return any one.

// Example :

// Input : [1 2 3 1 1]
// Output : 1
// 1 occurs 3 times which is more than 5/3 times.

// ********** 436/600 *********

public class Solution {

  // DO NOT MODIFY THE LIST
  public int repeatedNumber(final List<Integer> a) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

    if (a.size() == 0) {
      return -1;
    }

    if (a.size() == 1) {
      return a.get(0);
    }

    if (a.size() == 2) {
      return a.get(0);
    }

    float max = a.size() / 3;
    int value = -1;

    for (int x = 0; x < a.size(); x++) {
      Integer number = hash.get(a.get(x));

      if (number != null) {
        int count = hash.get(a.get(x));
        if (count + 1 > max) {
          // System.out.println(++count+" is the value and "+ max + " " + a.get(x));
          value = a.get(x);
          break;
        }
        hash.put(a.get(x), ++count);
      } else {
        hash.put(a.get(x), 1);
      }
    }

    return value;
  }
}
