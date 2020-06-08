import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class sortingByFrequency {

  public static void main(String[] args)
    throws NullPointerException, IOException {
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(sc.readLine());
    while (n != 0) {
      int size = Integer.parseInt(sc.readLine());
      int arr[] = new int[size];
      String[] temp = sc.readLine().trim().split("\\s+");

      for (int i = 0; i < size; i++) arr[i] = Integer.parseInt(temp[i]);

      ArrayList<Integer> ans = new ArrayList<Integer>();
      ans = new Sorting().sortByFreq(arr, size);
      //   for (int i = 0; i < ans.size(); i++) {
      //     System.out.print(ans.get(i) + " ");
      //   }
      //   System.out.println();
      n++;
    }
  }
}

class Sorting {

  ArrayList<Integer> sortByFreq(int arr[], int n) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    ArrayList<Integer> keys = new ArrayList<Integer>();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) {
      Integer value = hash.get(arr[i]);
      if (value == null) {
        hash.put(arr[i], 1);
        keys.add(arr[i]);
      } else {
        hash.put(arr[i], ++value);
      }
    }
    ArrayList<Integer> array2 = new ArrayList<Integer>();
    int size = hash.size();

    for (int i = 0; i < size; i++) {
      int max = 0;
      for (int j : keys) {
        if (max < hash.get(j)) {
          max = j;
        }
      }

      for (int k = 0; k < hash.get(max); k++) array2.add(max);

      hash.put(max, -1);
    }

    return array2;
  }
}
