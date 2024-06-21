class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        task(image,sr,sc,image.length,image[0].length,image[sr][sc],color);
        return image;
    }
    private void task(int image[][], int i, int j, int m, int n, int cur_col, int color)
    {
        if(i<0 || i>=m || j<0 || j>=n || image[i][j]!=cur_col || image[i][j]==color)
        {
            return;
        }
        image[i][j]=color;
        task(image,i+1,j,m,n,cur_col,color);
        task(image,i-1,j,m,n,cur_col,color);
        task(image,i,j+1,m,n,cur_col,color);
        task(image,i,j-1,m,n,cur_col,color);
    }
}