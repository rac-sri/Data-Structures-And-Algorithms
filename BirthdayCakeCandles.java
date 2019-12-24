package threestar;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BirthdayCakeCandles{
	static int birthdayCakeCandles(int ar[])
	{
		int max = ar[0]; int count = 1;
		for(int x=0 ; x<ar.length ; x++)
		{
			if(ar[x]>max)
				max = ar[x];
			if(ar[x]==max)
				count++;
		}
		return count;
	}
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException
	{
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("first.txt"));
		
		int arCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println(arCount);
		int[] ar = new int[arCount];
		
		
		for(int i =0 ; i< arCount ; i++)
		{
			int arItem = scanner.nextInt();
			ar[i] = arItem;
		}
		System.out.print(ar[0]);
		int result = birthdayCakeCandles(ar);
		bufferedWriter.write(String.valueOf(result));
		
		bufferedWriter.newLine();
		bufferedWriter.close();
		scanner.close();
		
	}
}