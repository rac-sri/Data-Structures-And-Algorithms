public class Solution {

  public int trailingZeroes(int A) {
    int arr[] = new int[100000];
    Arrays.fill(arr, 0);

    int q = 2;
    int len = 1;
    int carry = 0;
    int counter = 0;

    arr[0] = 1;

    while (q <= A) {
      counter = 0;
      carry = 0;

      while (counter < len) {
        arr[counter] = arr[counter] * q;
        arr[counter] += carry;
        carry = arr[counter] / 10;
        arr[counter] = arr[counter] % 10;
        counter++;
      }

      while (carry != 0) {
        arr[len] = carry % 10;
        carry /= 10;
        len++;
      }
      q++;
    }

    int counter2 = 0;
    int starter = 0;

    while (len >= starter) {
      //    System.out.print(arr[starter]);
      if (arr[starter] == 0) {
        counter2++;
      } else {
        break;
      }

      starter++;
    }

    return counter2;
  }
}

// second first time out : Just calcluate power of 5 sunce 10 = 5X2 and power of 10 will be equal to 5

public class Solution {

  public int trailingZeroes(int A) {
    int val = 5;
    int result = 0;
    while (true) {
      if (A < val) break;

      result = result + A / val;
      val = val * 5;
    }
    return result;
  }
}
