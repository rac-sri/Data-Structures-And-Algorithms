import java.util.Scanner;

public class FourSum {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int number = sc.nextInt();
    int arr[] = new int[length];
    for (int i = 0; i < length; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < length - 4; i++) {
      for (int j = i + 1; j < length - 3; j++) {
        int left = j + 1;
        int right = length - 1;
        int count = 0;
        while (left < right) {
          if (arr[left] + arr[right] + arr[i] + arr[j] == number) {
            if (count > 0) {
              System.out.print("$");
            }

            System.out.print(
              arr[i] + " " + arr[j] + " " + arr[left] + " " + arr[right]
            );
            count++;
          }
        }
      }
    }
  }
}
