public class Solution {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i=0;
        int j=0;
        
        while(j<b.size()){
            int value = b.get(j);
            
            while(i<a.size()){
                if(a.get(i) < value){
                    i++;
                }
                else {
                    break;
                }
            }
            
            a.add(i,value);
            j++;
        }
    }
}