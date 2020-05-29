import java.util.Scanner;

class BinaruSearchIn3DArray {

  public static void main(String[] args) {
    int r1, r2, r3, N, middle = 0;
    Scanner sc = new Scanner(System.in);
    r1 = sc.nextInt();
    r2 = sc.nextInt();
    r3 = sc.nextInt();
    N = sc.nextInt();

    int r1Position = 0, r2Positioin = 0;
    int universalTop = 0, universalBottom = 0;
    int totalLength = r1 * r2 * r3;
    int arr[] = new int[totalLength];

    for (int i = 0; i < totalLength; i++) {
      arr[i] = sc.nextInt();
    }
    boolean exists = false;
    int count = 0, starting = 0, ending = 0;
    int upper = r1 - 1;
    int lower = 0;
    while (lower <= upper) {
      count++;
      starting = 0;
      middle = lower + (upper - lower) / 2;
      // r2*r3 = 2*5 gives me the range length. Mulitply it by middle value of range gives me the range which is in the middle.
      /* * * *     if this is the front view
       * * *     *********** *********** *********** *********** ***********
       * * *   ->   this is middle. To reach it in the above seq. 2*5 = 10;we need to be at 21 (above) but we are at one.
       * * *        so we need to add 10 to 2*5 or muliply it by 2 = (3-1)/2
       * * *
       */
      starting = starting + middle * r2 * r3;
      ending = starting + r2 * r3 - 1;
      if (arr[starting] <= N && arr[ending] >= N) {
        System.out.println(arr[starting] + " " + arr[ending]);
        exists = true;
        r1Position = middle;
        break;
      }
      if (arr[starting] > N) {
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    universalTop = starting;
    universalBottom = ending;

    if (exists) {
      exists = false;
      upper = r2 - 1;
      lower = 0;
      while (upper >= lower) {
        count++;
        starting = 0;
        middle = lower + (upper - lower) / 2;
        starting = universalTop + middle * r3;
        ending = starting + r3 - 1;

        if (arr[starting] <= N && arr[ending] >= N) {
          System.out.println(arr[starting] + " " + arr[ending]);
          exists = true;
          r2Positioin = middle;
          break;
        }
        if (arr[starting] > N) {
          upper = middle - 1;
        } else lower = middle + 1;
      }

      universalTop = starting;
      universalBottom = ending;

      if (exists) {
        exists = false;
        upper = r3 - 1;
        lower = 0;
        while (upper >= lower) {
          count++;
          middle = lower + (upper - lower) / 2;

          if (arr[starting + middle] == N) {
            System.out.println(r1Position + " " + r2Positioin + " " + middle);
            exists = true;
            break;
          }
          if (arr[starting + middle] > N) {
            upper = middle - 1;
          } else {
            lower = middle + 1;
          }
        }
        if (!exists) System.out.println("0");
      } else {
        System.out.println("0");
      }
    } else {
      System.out.println("0");
    }

    System.out.println(count);
  }
}
