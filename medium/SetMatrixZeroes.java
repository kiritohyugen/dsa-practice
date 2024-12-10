// 73. Set Matrix Zeroes
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

import java.util.*;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> zeroPositions = new ArrayList<>();

        // Step 1: Identify all positions that contain zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    zeroPositions.add(new int[]{i, j});
                }
            }
        }

        // Step 2: Set entire row and column to zero for each zero found
        for (int[] position : zeroPositions) {
            int row = position[0];
            int col = position[1];

            // Set the entire row to zero
            for (int j = 0; j < n; j++){
                matrix[row][j] = 0;
            }

            // Set the entire column to zero
            for (int i = 0; i < m; i++){
                matrix[i][col] = 0;
            }
        }
    }

    public void setZeroesV2(int[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;

        boolean setFirstRowZero = false;
        boolean setFirstColZero = false;

        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0){
                setFirstColZero=true;
            }
        }

        for (int i = 0; i < n; i++) {
            if(matrix[0][i] == 0){
                setFirstRowZero=true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(setFirstRowZero){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if(setFirstColZero){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
    // Method to print the matrix
    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes setZero = new SetMatrixZeroes();
        
        // Example 1
        int[][] matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Original matrix:");
        setZero.printMatrix(matrix1);
        // setZero.setZeroes(matrix1);
        setZero.setZeroesV2(matrix1);

        System.out.println("Matrix after setting zeroes:");
        setZero.printMatrix(matrix1);

        // Example 2
        int[][] matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println("Original matrix:");
        setZero.printMatrix(matrix2);
        // setZero.setZeroes(matrix2);
        setZero.setZeroesV2(matrix2);
        System.out.println("Matrix after setting zeroes:");
        setZero.printMatrix(matrix2);
    }
}
