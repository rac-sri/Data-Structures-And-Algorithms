// Given a string A.

// Return the string A after reversing the string word by word.

// NOTE:

// A sequence of non-space characters constitutes a word.

// Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

// If there are multiple spaces between words, reduce them to a single space in the reversed string.

// Input Format

// The only argument given is string A.
// Output Format

// Return the string A after reversing the string word by word.
// For Example

// Input 1:
//     A = "the sky is blue"
// Output 1:
//     "blue is sky the"

// Input 2:
//     A = "this is ib"
// Output 2:
//     "ib is this"

// fails for multiple whitespaces cases
public class Solution {

  public String solve(String A) {
    String arr[] = A.split(" ");
    String str = "";

    for (int x = arr.length - 1; x > -1; x--) {
      str += arr[x] + " ";
    }

    String newstr = str.trim();

    return newstr;
  }
}

// works
public class Solution {

  public String reverseWords(String a) {
    String[] words = a.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      stringBuilder.append(words[i].trim());

      if (i != 0) {
        stringBuilder.append(" ");
      }
    }
    return stringBuilder.toString();
  }
}
