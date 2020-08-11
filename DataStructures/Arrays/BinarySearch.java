// Arrays.binarysearch(Array , key);
// Collections.binarySearch()
// The Collections.binarySearch() method is a Collections class method in Java that returns position of an object in a sorted list.

class Search {
    public static void main(String[] args){
        ...
    }

    int buinarySearch(int A[],int l, int r, int x){
        int present = -1;
        while(l<=r){
            int m = (l+r)/2;
            
            if(A[m] == x){
                present = x;
            }
            else if(A[m] > x){
                l = m;
            }
            else {
                r=m;
            }
        }
        return present;
    }
}