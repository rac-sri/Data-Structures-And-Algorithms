public class Solution {

  public ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> result = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
      return result;
    }

    String[] mapping = {
      "0",
      "1",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz",
    };

    letterCombinationRecursive(result, digits, "", 0, mapping);
    return result;
  }

  public void letterCombinationRecursive(
    ArrayList<String> result,
    String digits,
    String current,
    int index,
    String[] mapping
  ) {
    if (index == digits.length()) {
      result.add(current);
      return;
    }

    String letters = mapping[digits.charAt(index) - '0'];
    for (int i = 0; i < letters.length(); i++) {
      letterCombinationRecursive(
        result,
        digits,
        current + letters.charAt(i),
        index + 1,
        mapping
      );
    }
  }
}
