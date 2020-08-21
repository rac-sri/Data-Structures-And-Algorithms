class Bubble {

  public static void main(String[] args) {
    int arr[] = {
      1234,
      12,
      4,
      213,
      12,
      32,
      5,
      12,
      54376548,
      65,
      754,
      6,
      234,
      532,
      5,
    };
    int n = arr.length;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n - 1; y++) {
        if (arr[y] > arr[y + 1]) {
          int temp = arr[y];
          arr[y] = arr[y + 1];
          arr[y + 1] = temp;
        }
      }
    }

    for (int x = 0; x < n; x++) {
      System.out.print(arr[x] + " ");
    }
  }
}
