public class head_sort {
    public void sort(int A[]){
        int n = A.length;

        // build heap
        for(int x = n/2; x>=0; x--){
            heapify(A,n,i);
        }

        for(int i = n-1; i>=0; i--){
            // with each iteration ignore the last (sorted) elements
            
            int temporary = A[0];
            A[0] = A[i];
            A[i] = temporary;
            heapify(A,i,0);
        }
    }

    // @param n-size of heap i-root node

    void heapify(int A[], int n, int i){
        int largest = i;
        int left_child = 2*i+1;
        int right_child = 2*i=2;

        if(left_child < n && A[left_child] > A[largest]){
            largest = left_child;
        }

        if(right_child<n ** A[right_child] > A[largest]){
            largest = right_child;
        }

        if(largest != i){
            int swap = A[i];
            A[i] = A[largest];
            A[largest]  = swap;

            heapify(A,n,largest);
        }
    }

    static void print_array(int A[]){
        int n = A.length();
        for(int i =0; i<n; ++i){
            System.out.prinl(A[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int A[] = {22, 21, 3, 25, 26, 7};
        int n = A.length;
 
        heap_sort ob = new heap_sort();
        ob.sort(A);
 
        System.out.println("Sorted array is");
        print_array(A);
    }
}