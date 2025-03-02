package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ProblemH {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(printArr(getPointsArr(arr))); ;
        }
    }

    static int[] getPointsArr(int[] arr) {
        int[][] arrIndexed = new int[arr.length][2];
        for (int j = 0; j < arr.length; j++) {
            arrIndexed[j][0] = arr[j];
            arrIndexed[j][1] = j;
        }
        Arrays.sort(arrIndexed, Comparator.comparingInt(a -> a[0]));
        long[] prefSumArr = new long[arrIndexed.length];
        long sum = 0;
        for (int i = 0; i < prefSumArr.length; i++) {
            sum += arrIndexed[i][0];
            prefSumArr[i] = sum;
        }
        int[] result = new int[arr.length];
        int pointer = 0;
        int resultIndex = 0;
        while (resultIndex < arr.length) {
            if (pointer < resultIndex) {
                pointer++;
            }
            while (pointer < arr.length - 1 &&  prefSumArr[pointer] >= arrIndexed[pointer + 1][0]) {
                pointer++;
            }
            result[arrIndexed[resultIndex][1]] = pointer;
            resultIndex++;
        }
        result[arrIndexed[arr.length - 1][1]] = arr.length - 1;
        return result;
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
