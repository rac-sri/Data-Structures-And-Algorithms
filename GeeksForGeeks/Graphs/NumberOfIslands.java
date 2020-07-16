
// Description - Given a boolean 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 5 islands
// Example:
// Input : mat[][] = {{1, 1, 0, 0, 0},
//                    {0, 1, 0, 0, 1},
//                    {1, 0, 0, 1, 1},
//                    {0, 0, 0, 0, 0},
//                    {1, 0, 1, 0, 1} 
// Output : 5


import java.util.*;

public class NumberOfIslands {
    void DFS(int M[][],int row, int col, boolean visited[][]){
        int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for(int k=0;k<8;k++){
            if(isSafe(M,row + rowNbr[k], col+colNbr[k],visited))
                DFS(M,row + rowNbr[k], col+colNbr[k],visited);
        }
    }

    int countIslands(int M[][]){
        bool visited[ROW,COL];
        memset(visited,0,sizeof(visited));

        for (int i = 0; i < ROW; ++i) 
        for (int j = 0; j < COL; ++j) 
  
            if (M[i][j] && !visited[i][j]) { 
                DFS(M, i, j, visited) 
  
                ++count;
            } 
  
    return count;
    }
}