package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemE {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] params = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[][] matrix = new int[n][m];
            for (int j = 0; j < n; j++) {
                matrix[j] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            matrixStabilization(matrix);
            printMatrix(matrix);
        }
    }

    static void matrixStabilization(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                List<int[]> moves = generateMoves(matrix, i, j);
                int maxValNear = -1;
                for (int[] move : moves) {
                    if (matrix[move[0]][move[1]] > maxValNear) {
                        maxValNear = matrix[move[0]][move[1]];
                    }
                }
                if (matrix[i][j] > maxValNear) {
                    matrix[i][j] = maxValNear;
                }
            }
        }
    }

    static List<int[]> generateMoves(int[][] matrix, int i, int j) {
        List<int[]> moves = new ArrayList<>();
        if (i > 0) {
            moves.add(new int[]{i - 1, j});
        }
        if (j < matrix[0].length - 1) {
            moves.add(new int[]{i, j + 1});
        }
        if (i < matrix.length - 1) {
            moves.add(new int[]{i + 1, j});
        }
        if (j > 0) {
            moves.add(new int[]{i, j - 1});
        }
        return moves;
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(printArr(matrix[i]));
        }
    }
    static String printArr(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            stringBuilder.append(arr[i]).append(" ");
        }
        stringBuilder.append(arr[arr.length - 1]);
        return stringBuilder.toString();
    }
}
