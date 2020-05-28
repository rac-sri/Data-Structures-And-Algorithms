package threestar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HashCodeBooksAndLibaries{
	
	
	
	public static int check(int days , int scores[] , int numberOfBooks) {
//		List<Pair<Integer,Integer>> pairing = new ArrayList<Pair<Integer,Integer>>();
//		for(int x=0;x<scores.length;x++) {
//			Pair<Integer , Integer> newPair = new Pair<Integer , Integer>(scores[x] , books[x]);
//			pairing.add(newPair);
//		}
		int sum=0;
			for(int x=0; x<scores.length ; x++) {
				sum+=scores[x];
			}
		int max = sum/(days + numberOfBooks); 
		return max;
		
	}
	
	

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		File myObj = new File("example.txt");
	      Scanner myReader = new Scanner(myObj);
	      while(myReader.hasNextLine()) {
	    	   String data = myReader.nextLine();
	    	   System.out.println(data);
	      }
	      List books = new ArrayList();
	      int max=0;
	      while(m!=0)
	      {
	    	  for(int x = 0; x< library.length() ; x++) {
	    	  int score = check(days, scores[] , numberOfBooks);	    		  }
	    	  	if(max<score)
	    	  	{  		max = score;
	      
	    	  for(int x = 0 ;x<book.length(); x++) {
	    		  books.add(book[x]);
	    	  }}
	      }}
	}

}
