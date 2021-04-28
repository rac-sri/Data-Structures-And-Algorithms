// Missed : To track the points repitition and if in comparison points are getting repeated,

// public class Solution {

//   class Point {
//     int x;
//     int y;

//     public Point(int x, int y) {
//       this.x = x;
//       this.y = y;
//     }
//   }

//   public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
//     HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
//     int n = a.size();

//     if (n < 2) {
//       return n;
//     }
//     for (int x = 0; x < n; x++) {
//       Point p = new Point(a.get(x), b.get(x));
//       int same = 0;
//       int slope;

//       for (int y = x + 1; y < n; y++) {
//         Point p2 = new Point(a.get(y), b.get(y));

//         // if(a.get(x) == b.get(x) && a.get(y) == b.get(y)){
//         //     same ++;
//         //     continue;
//         // }

//         if ((p.x - p2.x) == 0) {
//           slope = Integer.MAX_VALUE;
//         } else {
//           slope = slope(p, p2);
//         }

//         if (hash.containsKey(slope)) {
//           hash.put(slope, hash.get(slope) + 1);
//         } else {
//           hash.put(slope, 1);
//         }
//         //    hash.put(slope, Math.max(hash.get(slope) , same));
//       }
//     }

//     int max = 0;

//     for (Integer i : hash.values()) {
//       if (i > max) {
//         max = i;
//       }
//     }

//     return max;
//   }

//   public int slope(Point p1, Point p2) {
//     return (p1.y - p2.y) / (p1.x - p2.x);
//   }
// }

public class Solution {

  class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    HashMap<Point, Integer> used = new HashMap<Point, Integer>();

    int n = a.size();

    if (n < 2) {
      return n;
    }

    int max = 1;

    for (int x = 0; x < n; x++) {
      Point p = new Point(a.get(x), b.get(x));
      int same = 0;
      int slope = 0;

      for (int y = x + 1; y < n; y++) {
        Point p2 = new Point(a.get(y), b.get(y));

        if ((p.x - p2.x) == 0) {
          slope = Integer.MAX_VALUE;
        } else {
          slope = slope(p, p2);
        }

        if (used.get(p2) == slope) {
          same++;
          continue;
        }

        if (hash.containsKey(slope)) {
          hash.put(slope, hash.get(slope) + 1);
        } else {
          hash.put(slope, 1);
        }

        used.put(p2, slope);
      }

      hash.put(slope, hash.get(slope) + same);
    }

    System.out.print(hash);

    for (Integer i : hash.values()) {
      if (i > max) {
        max = i;
      }
    }

    return max;
  }

  public int slope(Point p1, Point p2) {
    return (p1.y - p2.y) / (p1.x - p2.x);
  }
}
