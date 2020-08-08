// Given a list of non negative integers, arrange them such that they form the largest number.

// For example:

// Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// TIMEOUT:
public class Solution {

  // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
  public String largestNumber(final int[] A) {
    String max = "0";
    String number = "";
    int[] copy = A;

    boolean proceed = true;
    boolean first = true;
    int position = 0;
    while (proceed) {
      if (!first) {
        copy[position] = -1;
      }
      first = false;
      boolean modify = false;

      for (int x = 0; x < A.length; x++) {
        if (copy[x] > -1) {
          modify = true;
          String temp = String.valueOf(copy[x]);
          if (compare(max, temp) == temp) {
            max = temp;
            position = x;
          }
        }
      }
      // System.out.print("MAximum " + max + " " + position);
      // for(int x=0;x<copy.length;x++){
      //     System.out.print(copy[x]);
      // }
      if (modify) {
        number += max;
        max = "0";
      }

      for (int x = 0; x < copy.length; x++) {
        if (copy[x] != -1) {
          proceed = true;
          break;
        } else {
          proceed = false;
        }
      }
    }

    if (number.charAt(0) == '0') {
      number = "0";
    }
    return number;
  }

  String compare(String a, String b) {
    String ab = a + b;
    String ba = b + a;

    return ab.compareTo(ba) > 0 ? a : b;
  }
}

// ALL TEST CASES

public class Solution {

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public String largestNumber(final List<Integer> A) {
    String[] list = new String[A.size()];
    for (int i = 0; i < A.size(); i++) list[i] = String.valueOf(A.get(i));

    Comparator<String> comp = new Comparator<String>() {

      @Override
      public int compare(String s1, String s2) {
        String a = s1 + s2;
        String b = s2 + s1;

        return b.compareTo(a);
      }
    };

    Arrays.sort(list, comp);
    StringBuilder sb = new StringBuilder("");
    for (String str : list) sb.append(str);

    if (sb.toString().charAt(0) == '0') return "0";

    return sb.toString();
  }
}
