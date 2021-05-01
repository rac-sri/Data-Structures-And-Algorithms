public class Solution {

  public static int lengthOfLongestSubstring(String A) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    int result = 0, curLongest = 0;
    for (int i = 0; i < A.length(); i++) {
      char ch = A.charAt(i);

      if (!map.containsKey(ch)) {
        curLongest++;
        result = Math.max(result, curLongest);
        map.put(ch, i);
      } else {
        curLongest = 0;
        i = map.get(ch);
        map.clear();
      }
    }
    return result;
  }
}
