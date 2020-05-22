import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long arr[] = new long[n];

        for (int p = 0; p < m; p++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = sc.nextInt();
            arr[x - 1] += sum;
            if (y < n)
                arr[y] -= sum;
        }
        long max = 0;
        long c = 0;
        for (int x = 0; x < n; x++) {
            c = c + arr[x];
            if (c > max)
                max = c;
        }
        System.out.println(max);
    }

}
