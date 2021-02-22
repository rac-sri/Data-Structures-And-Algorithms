public class Solution {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int singleNumber(final List<Integer> A) {
    Map<Integer, Integer> h = new HashMap();

    for (int x = 0; x < A.size(); x++) {
      if (h.get(A.get(x)) != null) {
        h.put(A.get(x), h.get(A.get(x)) + 1);
      } else {
        h.put(A.get(x), 1);
      }
    }

    int answer = 0;

    for (Integer key : h.keySet()) {
      if (h.get(key) == 1) {
        answer = key;
      }
    }

    return answer;
  }
}
