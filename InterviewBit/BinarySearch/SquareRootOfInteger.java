// Given an integar A.

// Compute and return the square root of A.

// If A is not a perfect square, return floor(sqrt(A)).

// DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY

// Input Format

// The first and only argument given is the integer A.
// Output Format

// Return floor(sqrt(A))
// Constraints

// 1 <= A <= 10^9
// For Example

// Input 1:
//     A = 11
// Output 1:
//     3

// Input 2:
//     A = 9
// Output 2:
//     3

// Newton Raphson Method

// Take a reasonable guess (approximate root) for the square root.
// Add the approximate root with the original number divided by the approximate root and divide by 2.
// x_i := (x_i + n / x_i) / 2
// Continue step 2 until the difference in the approximate root along the iterations is less than the desired value (or precision value).
// The approximate root is the square root we want.

public class Solution {

  public int sqrt(int A) {
    double precision = 0.0001;
    double x0 = A;

    while (Math.abs(A - (x0 * x0)) > precision) x0 = (x0 + A / x0) / 2;

    //System.out.println(x0);
    return (int) Math.floor(x0);
  }
}
