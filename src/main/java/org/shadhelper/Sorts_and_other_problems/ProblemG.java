package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemG {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] arrA = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arrB = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(computeMaxDiff(arrA, arrB));
        }
    }

    static long computeMaxDiff(int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int leftA = 0;
        int leftB = 0;
        int rightA = arrA.length - 1;
        int rightB = arrB.length - 1;
        long maxDiff = 0;
        while (leftA <= rightA) {
            if (Math.abs(arrA[leftA] - arrB[rightB]) > Math.abs(arrA[rightA] - arrB[leftB])) {
                maxDiff += Math.abs(arrA[leftA] - arrB[rightB]);
                leftA++;
                rightB--;
            } else {
                maxDiff += Math.abs(arrA[rightA] - arrB[leftB]);
                rightA--;
                leftB++;
            }
        }
        return maxDiff;
    }
}
