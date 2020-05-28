/* package codechef; // don't place package name! */

import java.util.*;
import java.util.Scanner;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main(String[] args) throws IOException {
        LinkedList<Integer> L1 = new LinkedList<Integer>();
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        LinkedList<Integer> L3 = new LinkedList<Integer>();
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int N = sc.nextInt();
    
        for (int x = 0; x < N * 2; x++) {
          L1.add(sc.nextInt());
        }
    
        for (int i = 0; i < N * 2 - 2; i++) {
          if (i % 2 == 0) {
            L2.add(L1.get(i) + L1.get(i + 2));
          } else {
            L3.add(L1.get(i) + L1.get(i + 2));
          }
        }
    
        int count = 0;
        int licount = 0;
        while (count < L2.size()) {
          L1.add(++licount, L2.get(count));
          ++licount;
          count++;
        }
    
        ++licount;
        count = 0;
    
        while (count < L3.size()) {
          L1.add(++licount, L3.get(count));
          ++licount;
          count++;
        }
    
        int middle = L1.getFirst() + L1.getLast();
    
        int pos = L1.size() / 2;
    
        L1.add(pos, middle);
    
        //printing
        for (int i : L2) {
          System.out.print(i+ " ");
        }
    
        System.out.print("\n");
    
        for (int i : L3) {
          System.out.print(i+ " ");
        }
    
        System.out.print("\n");
    
        System.out.print(middle);
    
        System.out.print("\n");
    
        for (int i : L1) {
          System.out.print(i+ " ");
        }
    
        System.out.print("\n");
    
        System.out.print(L1.size());
      }
}
