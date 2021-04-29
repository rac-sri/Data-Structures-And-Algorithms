public class Solution {

  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public boolean equals(Object ob) {
      if (ob instanceof Point) {
        Point p1 = (Point) ob;
        return this.x == p1.x && this.y == p1.y;
      }

      return false;
    }

    public int hashCode() {
      return (this.x + "-" + this.y).hashCode();
    }
  }

  public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
    int n = a.size();
    if (n < 2) {
      return n;
    }

    HashSet<Point> set = new HashSet<Point>();

    int max = -1;

    // to summarize the logic
    // first point matches with all other. If there are multiple plance ( for eg take origin as the starting point ), them the max in Hashmap declred below will contain that
    // for the next point, the map is empty. So now we are checking if there is any other line on which point 2nd necessarily lies. Thses need not pass through origin.
    // hence localmax + same , and max of all previous loops gives us the answer.
    // Note: We can add points up in the loops, that would be reptiting the same point at i position multiple times in output.

    for (int i = 0; i < n; i++) {
      Point p1 = new Point(a.get(i), b.get(i));

      if (!set.contains(p1)) {
        int same = 0;

        // store all slope of all lines on which p1 lies

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int localMax = 1;

        for (int j = i + 1; j < n; j++) {
          Point p2 = new Point(a.get(j), b.get(j));

          if (p2.equals(p1)) {
            same++;
            continue;
          }

          String slope = getSlope(p1, p2);
          map.put(slope, map.getOrDefault(slope, 1) + 1);
          localMax = Math.max(localMax, map.get(slope));
        }

        set.add(p1);
        max = Math.max(max, localMax + same);
      }
    }

    return max;
  }

  public String getSlope(Point p1, Point p2) {
    if (p1.x == p2.x) return "-INF";

    if (p1.y == p2.y) return "0";

    long xdiff = (long) p1.x - (long) p2.x;
    long ydiff = (long) p1.y - (long) p2.y;

    long g = gcd(Math.abs(xdiff), Math.abs(ydiff));

    // handling sign as -2/-3 as 2/3

    String sign = ((ydiff < 0 && xdiff < 0) || (ydiff > 0 && xdiff > 0))
      ? ""
      : "-";

    return sign + (Math.abs(ydiff) / g) + "/" + (Math.abs(xdiff) / g);
  }

  // gcd euclid's algorithm
  public long gcd(long a, long b) {
    if (a < b) return gcd(b, a);

    if (b == 0) return a;

    return gcd(b, a % b);
  }
}
