class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,j=matrix.length-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(matrix[mid][0]==target)
            {
                return true;
            }
            else if(matrix[mid][0]<target)
            {
                i=mid+1;
            }
            else
            {
                j=mid-1;
            }
        }
        if(j<0 || i>matrix.length)
        {
            return false;
        }
        int i1=0,j1=matrix[0].length-1;
        while(i1<=j1)
        {
            int mid=(i1+j1)/2;
            if(matrix[j][mid]==target)
            {
                return true;
            }
            else if(matrix[j][mid]<target)
            {
                i1=mid+1;
            }
            else
            {
                j1=mid-1;
            }
        }
        return false;
    }
}