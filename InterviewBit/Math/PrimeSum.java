// Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

// NOTE A solution will always exist. read Goldbach’s conjecture

// Example:

// Input : 4
// Output: 2 + 2 = 4

// If there are more than one solutions possible, return the lexicographically smaller solution.

// If [a, b] is one solution with a <= b,
// and [c,d] is another solution with c <= d, then

// [a, b] < [c, d]

// If a < c OR a==c AND b < d.

public class Solution {

  public ArrayList<Integer> primesum(int A) {
    ArrayList<Integer> m = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 2; i < A; i++) {
      if (isPrime(i)) {
        m.add(i);
      }
    }

    for (int i = 0, j = m.size() - 1; i < m.size() && i <= j;) {
      if (m.get(i) + m.get(j) == A) {
        res.add(m.get(i));
        res.add(m.get(j));
        return res;
      } else if (m.get(i) + m.get(j) > A) {
        j--;
      } else if (m.get(i) + m.get(j) < A) {
        i++;
      }
    }
    return res;
  }

  public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;

    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i * i <= n; i = i + 6) if (
      n % i == 0 || n % (i + 2) == 0
    ) return false;

    return true;
  }
}
