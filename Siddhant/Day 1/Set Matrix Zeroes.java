class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int extra=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(j==0)
                    {
                        extra=0;
                    }
                    else
                    {
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }
        for(int i=m-1;i>=1;i--)
        {
            for(int j=n-1;j>=1;j--)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                {
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=n-1;j>=0;j--)
        {
            if(matrix[0][0] == 0)
            {
                matrix[0][j]=0;
            }
        }
        for(int i=m-1;i>=0;i--)
        {
            if(extra==0)
            {
                matrix[i][0]=0;
            }
        }
    }
}