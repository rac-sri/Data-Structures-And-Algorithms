public class Solution {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
    HashMap<HashMap<Character, Integer>, ArrayList<Integer>> hash = new HashMap<HashMap<Character, Integer>, ArrayList<Integer>>();

    for (int x = 0; x < A.size(); x++) {
      String s = A.get(x);

      HashMap<Character, Integer> temp = new HashMap<Character, Integer>();

      for (int y = 0; y < s.length(); y++) {
        char c = s.charAt(y);
        if (!temp.containsKey(c)) temp.put(c, 1); else {
          temp.put(c, temp.get(c) + 1);
        }
      }

      if (hash.containsKey(temp)) {
        ArrayList<Integer> arr = hash.get(temp);
        arr.add(x + 1);
        hash.put(temp, arr);
      } else {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(x + 1);
        hash.put(temp, arr);
      }
    }

    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

    for (ArrayList s : hash.values()) {
      //    System.out.println(s);
      arr.add(s);
    }

    return arr;
  }
}
