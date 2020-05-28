package threestar;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.stream.*;

public class GradingStudents {

  public static List<Integer> gradingStudents(List<Integer> grades) {
    int l = grades.size();
    List<Integer> rounded = new ArrayList<Integer>();
    for (int x = 0; x < l; x++) {
      int marks = grades.get(x);
      if (marks < 38) rounded.add(marks); else {
        int xx = roundCheck(marks);

        rounded.add(xx);
      }
    }
    return rounded;
  }

  public static int roundCheck(int x) {
    int multi = (int) x / 5;
    int upper = 5 * (multi + 1);

    if ((upper - x) < 3) return upper; else return x;
  }

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    BufferedReader bufferedReader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    BufferedWriter bufferedWriter = new BufferedWriter(
      new FileWriter("GradingStudetns.txt")
    );
    int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
    List<Integer> grades = IntStream
      .range(0, gradesCount)
      .mapToObj(
        i -> {
          try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        }
      )
      .map(String::trim)
      .map(Integer::parseInt)
      .collect(toList());

    List<Integer> result = gradingStudents(grades);

    bufferedWriter.write(
      result.stream().map(Object::toString).collect(joining("\n")) + "\n"
    );
    bufferedReader.close();
    bufferedWriter.close();
  }
}
