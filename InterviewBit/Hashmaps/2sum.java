// Mistake: Index minimum, solved using value minimum

// public class Solution {

//   // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
//   public int[] twoSum(final int[] A, int B) {
//     HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

//     for (int x = 0; x < A.length; x++) {
//       if (hash.containsKey(A[x])) {
//         continue;
//       }

//       hash.put(A[x], x);
//     }

//     int arr[] = new int[2];
//     arr[1] = Integer.MAX_VALUE;

//     for (int x = 0; x < A.length; x++) {
//       int n1 = A[x];
//       int n2 = B - A[x];

//       if (hash.containsKey(n2)) {
//         int number1 = hash.get(n1);
//         int number2 = hash.get(n2);
//         if (number2 < arr[1]) {
//           arr[0] = number1;
//           arr[1] = number2;
//         }
//       }
//     }

//     return arr;
//   }
// }

public class Solution {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public class Pair {
    int minIndex;
    int maxIndex;

    Pair(int m, int n) {
      minIndex = m;
      maxIndex = n;
    }
  }

  public ArrayList<Integer> twoSum(final List<Integer> arr, int target) {
    Map<Integer, Pair> mp = new HashMap<>();
    if (arr.size() <= 1) return new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      if (mp.containsKey(arr.get(i))) {
        if (mp.get(arr.get(i)).maxIndex == mp.get(arr.get(i)).minIndex) mp.put(
          arr.get(i),
          new Pair(mp.get(arr.get(i)).minIndex, i)
        );
      } else {
        mp.put(arr.get(i), new Pair(i, i));
      }
    }
    int index1 = Integer.MAX_VALUE, index2 = Integer.MAX_VALUE, cur;
    for (int i = 0; i < arr.size(); i++) {
      cur = target - arr.get(i);
      if (mp.containsKey(cur)) {
        Pair p = mp.get(cur);
        if (
          arr.get(i) == arr.get(p.minIndex) &&
          p.maxIndex - i > 0 &&
          p.maxIndex < index2
        ) {
          index1 = i;
          index2 = p.maxIndex;
        } else if (p.minIndex - i > 0 && p.minIndex < index2) {
          index1 = i;
          index2 = p.minIndex;
        }
      }
    }
    if (index1 == Integer.MAX_VALUE) return new ArrayList<>();
    return new ArrayList<>(Arrays.asList(index1 + 1, index2 + 1));
  }
}
