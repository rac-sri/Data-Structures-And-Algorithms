import java.util.*;

class Solution{
    public static void main(String[] args){
        PriorityQueue<Float> lower= new PriorityQueue<Float>(Collections.reverseOrder());
        PriorityQueue<Float> upper = new PriorityQueue<Float>();
        Scanner sc= new Scanner(System.in);

        int n = sc.nextInt()-2;
        float first = sc.nextFloat();
        float second = sc.nextFloat();
        System.out.println(first);
        System.out.println((first+second)/2);
        if(first<=second){lower.add(first);upper.add(second);} else {lower.add(second); upper.add(first);}
        while(n-->0){
            float newNumber = sc.nextInt();
            int sizeLower = lower.size();
            int sizeUpper = upper.size();
            float upperno = upper.peek();
            float lowerno = lower.peek();

            if(sizeLower <= sizeUpper){

                if(newNumber <= upperno){
                    lower.add(newNumber);
                }
                else{
                    lower.add(upper.poll());
                    upper.add(newNumber);
                }
            }
            else {
                if(newNumber > lowerno){
                    upper.add(newNumber);
                }
                else{
                    upper.add(lower.poll());
                    lower.add(newNumber);
                }
            }

            if(lower.size()==upper.size()){
                System.out.println((lower.peek()+upper.peek())/2);
            }
            else System.out.println(lower.peek());
        }

}
}
