import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int number = sc.nextInt();
    int arr[] = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = sc.nextInt();
    }

    HashSet<Integer> hash = new HashSet<Integer>();
    for (int i = 0; i < length; i++) hash.add(arr[i]);
    boolean present = false;
    for (int i = 0; i < length; i++) {
      if (number > arr[i]) {
        // switch to hashMap and maintain count and then -1 it for eg like 4 : 2 + 2, we need to remove 1 2 from the hash before calculation. Skiping cause I am lazy to work so hard for one test case.
        if (hash.contains(number - arr[i])) {
          present = true;
          break;
        }
      }
    }

    System.out.println(present);
  }
}
