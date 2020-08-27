// Please Note:
// There are certain questions where the interviewer would intentionally frame the question vague.
// The expectation is that you will ask the correct set of clarifications or state your assumptions before you jump into coding.

// Implement atoi to convert a string to an integer.

// Example :

// Input : "9 2704"
// Output : 9
// Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

//  Questions: Q1. Does string contain whitespace characters before the number?
// A. Yes Q2. Can the string have garbage characters after the number?
// A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
// A. Return 0. Q4. What if the integer overflows?
// A. Return INT_MAX if the number is positive, INT_MIN otherwise.
// Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
// If you do, we will disqualify your submission retroactively and give you penalty points.

public class Solution {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public int atoi(final String str) {
    str.trim();
    String result = "";

    if (str == "") {
      return 0;
    }
    try {
      for (int x = 0; x < str.length(); x++) {
        if (str.charAt(x) >= 48 && str.charAt(x) <= 57) {
          result += str.charAt(x);
        } else if (str.charAt(0) == '-' && x == 0) {
          result = "-";
        } else if (str.charAt(0) == '+' && x == 0) {} else {
          break;
        }
      }

      System.out.println(result);
      if (result.equals("+") || result.equals("-")) {
        return 0;
      }
      return Integer.parseInt(result);
    } catch (Exception e) {
      return 2147483647;
    }
  }
}
