import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        while(i<h.length){
            System.out.println(h[i]);
            if(stack.isEmpty() || h[stack.peek()]<=h[i]){
                System.out.println("innnnnnnn2");
                stack.push(i);
                i++;
           }
            else {
                int currMax = stack.pop(); // this is i-1 value 
                int area = h[currMax] * (stack.isEmpty()?(i):i-1 - stack.peek()); // basically since stack contains the index of my smaller building
                System.out.println("innnnnnnn");
                if(area>max)
                max = area;
            }

        }
            while(!stack.isEmpty()){
                int currMax = stack.pop();
                int area = h[currMax] * (stack.isEmpty()?(i):i-1 - stack.peek());
                if(area>max)
                max = area;
            }
    return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
