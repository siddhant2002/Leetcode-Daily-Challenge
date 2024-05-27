class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // Take two flag variables isRow and isCol and check if the first row
        // and first column contain any  zero or not.

        // Then check for 0s in the matrix except for first row and column.
        // If you find any zero then update the first cell of the corresponding
        // row and column

        // Then iterate again the matrix from the second row and column.
        // Update that cell to 0 if the first cell of that corresponding row 
        // or column has zero in it

        // Then, if isRow = true, then fill the first row with zeros
        // Then, if isCol = true, then fill the first column with zeros

        boolean isRow = false, isCol = false;

        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                isCol = true;
                break;
            }
        }

        for(int j = 0; j < n; j++) {
            if(matrix[0][j] == 0) {
                isRow = true;
                break;
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(isRow) {
            for(int j=  0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(isCol) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}