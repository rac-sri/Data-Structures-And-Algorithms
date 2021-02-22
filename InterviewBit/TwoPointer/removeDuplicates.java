public class Solution {

  public int removeDuplicates(ArrayList a) {
    int size = a.size();
    int curIndex = 0;

    for (int i = 0; i < size; i++) {
      if (!(a.get(i).equals(a.get(curIndex)))) {
        a.set(++curIndex, a.get(i));
      }
    }
    return curIndex + 1;
  }
}
