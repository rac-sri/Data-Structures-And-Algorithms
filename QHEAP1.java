import java.io.*;
import java.util.*;

public class QHEAP1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pr = new PriorityQueue<Integer>();
        while(n-->0){
            int choice = sc.nextInt();
            switch(choice){
                case 1: 
                    int no = sc.nextInt();
                    pr.add(no);
                    break;
                case 2:
                    int no2 = sc.nextInt();
                    pr.remove(no2);
                    break;
                case 3:
                    int value = pr.remove();
                    System.out.println(value);
                    pr.add(value);
                    break;
            }
        }
    }
}