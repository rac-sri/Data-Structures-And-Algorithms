public class Solution {

  public ArrayList<ArrayList<Integer>> combinationSum(
    ArrayList<Integer> a,
    int b
  ) {
    Set<ArrayList<Integer>> result = new HashSet();
    Collections.sort(a);
    backtrack(a, 0, b, new ArrayList(), result);
    return new ArrayList(result);
  }

  private void backtrack(
    ArrayList<Integer> cand,
    int start,
    int target,
    ArrayList<Integer> list,
    Set<ArrayList<Integer>> result
  ) {
    if (target < 0) return;
    if (target == 0) {
      result.add(new ArrayList(list));
    }
    for (int i = start; i < cand.size(); i++) {
      list.add(cand.get(i));
      backtrack(cand, i + 1, target - cand.get(i), list, result);
      list.remove(list.size() - 1);
    }
  }
}
