class SelectionSort {

  public static void main(String[] args) {
    int arr[] = {
      214,
      12,
      421,
      4,
      132,
      5125,
      12,
      5,
      3,
      123,
      12,
      4,
      12,
      412,
      5,
      125,
      13,
      4,
      2,
      421,
      5,
      32,
      6534,
      7,
      56,
      865,
      34,
    };
    int n = arr.length;

    int min = Integer.MAX_VALUE;

    for (int x = 0; x < n - 1; x++) {
      int position = x;

      for (int y = x + 1; y < n; y++) {
        if (arr[y] < arr[position]) {
          position = y;
        }
      }
      int temp = arr[x];
      arr[x] = arr[position];
      arr[position] = temp;
    }

    for (int x = 0; x < n; x++) {
      System.out.print(arr[x] + " ");
    }
  }
}
