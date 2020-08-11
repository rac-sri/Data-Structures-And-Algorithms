class Ternary{

    public static void main(String[] args){
        //...
    }

    int ternary(int A[], int r, int key, int l){
        int value = -1;
        while(l<=r){
            int mid1 = l+((r-l)/3);
            int mid2 = r-((r-l)/3);

            if(A[mid1] == key){
                value = mid1;
                break;
            }
            elseif(A[mid2] == key){
                value = mid2;
                break;
            }

            if(key< A[mid1]){
                l = mid1 - 1;
            }
            else if(key > A[mid2]){
                r = mid2 +1;
            }

            else {
                l = mid1 +1;
                r = mid2 -1;
            }
            
        }
        return value;
    }
}