import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArrayProblem {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int numQueries = scan.nextInt();

		List<List<Integer>> seq = new ArrayList<List<Integer>>(n);
		for (int i = 0; i < n; i++) {
			seq.add(new ArrayList<Integer>());
		}
		int lastAns = 0;
		for (int i = 0; i < numQueries; i++) {
			int queryType = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();
			int seqIndex = ((x ^ lastAns) % n);
			List<Integer> curSeq = seq.get(seqIndex);
			if (queryType == 1) {
				curSeq.add(y);
			} else {
				lastAns = curSeq.get(y % curSeq.size());
				System.out.println(lastAns);
			}
		}
	}
}
