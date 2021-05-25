public class Solution {
  private final Map<Integer, Integer> cache;

  public Solution(int capacity) {
    this.cache =
      new LinkedHashMap<Integer, Integer>(capacity, 100.0f, true) {

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
          return size() > capacity;
        }
      };
  }

  public int get(int key) {
    if (cache.containsKey(key)) return cache.get(key);
    return -1;
  }

  public void set(int key, int value) {
    cache.put(key, value);
  }
}
