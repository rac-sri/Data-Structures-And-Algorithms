import java.util.stream.Collectors;

public class Solution {
  ArrayList<ArrayList<Integer>> res = new ArrayList<>();
  ArrayList<Integer> a;
  int b;

  public ArrayList<ArrayList<Integer>> combinationSum(
    ArrayList<Integer> a,
    int b
  ) {
    if (!(b <= 0 || a == null || a.size() == 0)) {
      a = new ArrayList<>(new HashSet<>(a));
      Collections.sort(a);
      this.a = a;
      this.b = b;
      comb(new ArrayList<>(), 0, 0);
    }
    return res;
  }

  private void comb(ArrayList<Integer> ar, int cumSum, int ix) {
    if (cumSum == b) res.add(new ArrayList<>(ar)); else if (cumSum < b) {
      for (int i = ix; i < a.size(); i++) {
        ar.add(a.get(i));
        comb(ar, cumSum + a.get(i), i);
        ar.remove(ar.size() - 1);
      }
    }
  }
}
