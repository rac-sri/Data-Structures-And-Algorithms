class Insertions {

  public static void insert(int arr[], int n) {
    for (int i = 1; i < n; i++) {
      key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j -= 1;
      }
      arr[j + 1] = key;
    }
  }
}
