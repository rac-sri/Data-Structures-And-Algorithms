class InsertionSort {

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

    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j -= 1;
      }
      arr[j + 1] = key;
    }

    for (int x = 0; x < n; x++) {
      System.out.print(arr[x] + " ");
    }
  }
}
