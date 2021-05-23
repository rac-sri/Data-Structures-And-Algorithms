public class Solution {

  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> num) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    if (num == null || num.size() == 0) return res;

    boolean[] used = new boolean[num.size()];
    ArrayList<Integer> permutaion = new ArrayList<>();

    permuteRecursive(num, permutaion, used, res);
    return res;
  }

  public void permuteRecursive(
    ArrayList<Integer> nums,
    ArrayList<Integer> permutation,
    boolean[] used,
    ArrayList<ArrayList<Integer>> res
  ) {
    if (permutation.size() == nums.size()) {
      res.add(new ArrayList<>(permutation));
      return;
    }

    for (int i = 0; i < nums.size(); ++i) {
      if (used[i]) {
        continue;
      }
      used[i] = true;
      permutation.add(nums.get(i));
      permuteRecursive(nums, permutation, used, res);
      permutation.remove(permutation.size() - 1);
      used[i] = false;
    }
  }
}
