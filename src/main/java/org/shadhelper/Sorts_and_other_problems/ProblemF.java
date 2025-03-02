package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemF {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] params = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int c = Integer.parseInt(params[1]);
            int d = Integer.parseInt(params[2]);
            int[] arrB = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String result =  checkProgressiveSquare(arrB, n, c, d) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    static boolean checkProgressiveSquare(int[] arrB, int n, int c, int d) {
        Arrays.sort(arrB);
        int minVal = arrB[0];
        int[] progressiveSquare = new int[arrB.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                progressiveSquare[i * n + j] = minVal + i * c + j * d;
            }
        }
        Arrays.sort(progressiveSquare);
        for (int i = 0; i < progressiveSquare.length; i++) {
            if (progressiveSquare[i] != arrB[i]) {
                return false;
            }
        }
        return true;
    }
}
