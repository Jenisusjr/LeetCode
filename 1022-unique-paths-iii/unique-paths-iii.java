class Solution {
    int[]d_r={1,-1,0,0};
    int[]d_c={0,0,-1,1};
    int row,col;
    int c=0;
    void backtrack(int[][] grid,int row,int col,int n,int m,int cell){
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==-1) return;
        if(grid[row][col]==2 && cell==-1){
            c++;
            return;
        }
        int temp=grid[row][col];
        grid[row][col]=-1;
        for(int k=0;k<4;k++){
            int next_r=row+d_r[k];
            int next_c=col+d_c[k];
            backtrack(grid,next_r,next_c,n,m,cell-1);
        }
        grid[row][col]=temp;
    }
    public int uniquePathsIII(int[][] grid) {
         int n=grid.length;
        int m=grid[0].length;
        int cell=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
                 if(grid[i][j]==0) cell++;
            }
        }
        backtrack(grid,row,col,n,m,cell);
        return c;
    }
}