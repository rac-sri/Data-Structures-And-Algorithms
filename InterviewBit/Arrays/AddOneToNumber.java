public class Solution {

  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    String s = "";
    while (A.size() > 0) {
      int size = A.size();
      s = A.get(size - 1) + s;
      A.remove(size - 1);
    }
    long n = Long.parseLong(s);
    n = n + 1;

    String s1 = String.valueOf(n);
    ArrayList<Integer> list = new ArrayList<Integer>();
    while (s1.length() > 0) {
      list.add(Character.getNumericValue(s1.charAt(0)));
      s1 = s1.substring(1);
    }
    return list;
  }
}

// wont work for numbers > long limit

// working
public class Solution {

  public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    int size = A.size();
    int backup = size;
    boolean proceed = false;
    boolean newList = false;
    while (!proceed) {
      int n = A.get(size - 1);
      if (size == 1 && n == 9) {
        newList = true;
        break;
      }
      if (n == 9) {
        A.set(size - 1, 0);
        size = size - 1;
      } else {
        A.set(size - 1, n + 1);
        break;
      }
    }
    while (A.get(0) == 0 && backup > 1) {
      A.remove(0);
    }
    if (newList) {
      ArrayList<Integer> newAList = new ArrayList<Integer>();
      newAList.add(1);
      for (int x = 0; x < backup; x++) {
        newAList.add(0);
      }
      return newAList;
    }
    return A;
  }
}
