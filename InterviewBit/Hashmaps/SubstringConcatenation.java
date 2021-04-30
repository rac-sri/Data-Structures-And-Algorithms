public class Solution {

  public ArrayList findSubstring(String A, final List<String> B) {
    int size_word = B.get(0).length();

    int word_count = B.size();

    int size_l = size_word * word_count;

    ArrayList<Integer> res = new ArrayList<Integer>();
    int n = A.length();

    if (size_l > n) {
      return res;
    }

    HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    for (String word : B) {
      hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
    }

    for (int i = 0; i <= n - size_l; i++) {
      HashMap<String, Integer> tempMap = (HashMap<String, Integer>) hashMap.clone();
      int j = i, count = word_count;

      while (j < i + size_l) {
        String word = A.substring(j, j + size_word);

        if (!hashMap.containsKey(word) || tempMap.get(word) == 0) {
          break;
        } else {
          tempMap.put(word, tempMap.get(word) - 1);
          count--;
        }
        j += size_word;
      }

      if (count == 0) {
        res.add(i);
      }
    }
    return res;
  }
}
