// Problem Description

// Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



// Input Format
// First and only argument is an integer array A.



// Output Format
// Return an integer denoting the maximum value of j - i;



// Example Input
// Input 1:

//  A = [3, 5, 4, 2]


// Example Output
// Output 1:

//  2


// Example Explanation
// Explanation 1:

//  Maximum value occurs for pair (3, 4).


// First Attempt

// public class Solution {
//     class Container {
//         int value;
//         int position;
//         Container(int a,int b){
//             value = a;
//             position = b;
//         }
//     }
    
//     // DO NOT MODIFY THE LIST. IT IS READ ONLY
//     public int maximumGap(final List<Integer> A) {
//         ArrayList<Container> arr = new ArrayList<Container>();
        
//         for(int x=0;x<A.size();x++){
//             arr.add(new Container(A.get(x),x));
//         }
        
//         Comparator<Container> comparator = new Comparator<Container>(){
//           @Override
//           public int compare(Container first, Container second){
//               return first.value-second.value;
//           }
//         };
        
//         Arrays.sort(arr,comparator);
        
        
//           int min_ind = arr.get(0).position;
//           int ans = 0;
//           for(int i=1;i<n;i++) {
//                 min_ind = min(min_ind,arr.get(0).position);
//                 ans = max(ans, arr.get(0).position - min_ind);
//     }
//     return ans;
//     }
// }


// Mine

public class Solution {
    class Container {
        int value;
        int position;
        Container(int a,int b){
            value = a;
            position = b;
        }
    }
    
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        ArrayList<Container> arr = new ArrayList<Container>();
        
        if(A.size() == 1 || A.size()==0){
            return 0;
        }
        for(int x=0;x<A.size();x++){
            arr.add(new Container(A.get(x),x));
        }
        
        Comparator<Container> comparator = new Comparator<Container>(){
          @Override
          public int compare(Container first, Container second){
              return first.value-second.value;
          }
        };
        
        arr.sort(comparator);
        
        int ans = Integer.MIN_VALUE;
        int maximum = arr.get(arr.size()-1).position;
        
        for(int x = arr.size()-2;x>-1;x--){
            
            ans = Math.max(maximum - arr.get(x).position,ans);
            maximum = Math.max(maximum,arr.get(x).position);
        }
 
        if(ans<0){
              ans = 0;
        }
        return ans;
    }
}


// FROM DISCUSSTION (NOT MINE). O(N) solution

public int maximumGap(final List integers) {
    if (integers.size()==1)
    return 0;
    
        int maxDiff;
        int i, j;
        int n =integers.size();
    
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = integers.get(0);

        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(integers.get(i), LMin[i - 1]);

        RMax[n - 1] = integers.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(integers.get(j), RMax[j + 1]);
    
        i=0;j=0;
        maxDiff=-1;
        while (i<n && j<n){
            if (LMin[i]<=RMax[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            }
            else
                i++;
        }
    
        return maxDiff;
    }