// Implement pow(x, n) % d.

// In other words, given x, n and d,

// find (xn % d)

// Note that remainders on division cannot be negative.
// In other words, make sure the answer you return is non negative.

// Input : x = 2, n = 3, d = 3
// Output : 2

// 2^3 % 3 = 8 % 3 = 2.

public class Solution {

  public int pow(int x, int n, int d) {
    long ans = 0;
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (x < 0) return pow(d + x, n, d);
    long temp = pow(x, n / 2, d);

    if (n % 2 == 0) {
      ans = ((temp % d) * (temp % d)) % d;
    } else {
      ans = ((((x % d) * (temp % d)) % d) * (temp % d)) % d;
    }

    return (int) ans % d;
  }
}
