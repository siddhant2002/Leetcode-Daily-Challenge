class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int dup=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=dup;
            }
        }
        for(int i=0;i<m;i++)
        {
            swap(matrix[i]);
        }
    }
    private void swap(int a[])
    {
        for(int i=0,j=a.length-1;i<=j;i++,j--)
        {
            int dup=a[i];
            a[i]=a[j];
            a[j]=dup;
        }
    }
}