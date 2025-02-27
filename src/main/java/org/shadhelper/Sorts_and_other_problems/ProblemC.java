package org.shadhelper.Sorts_and_other_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemC {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String result = isArrayPossible(arr) ? "YES" : "NO";
            System.out.println(result);
        }
    }

    static boolean isArrayPossible(int[] arr) {
        int prev = 0;
        while (prev < arr.length && arr[prev] != 1) {
            prev++;
        }
        int next = prev + 1;
        while (next < arr.length) {
            if (arr[next] == 1) {
                if (next - prev == 2) {
                    return false;
                } else {
                    prev = next;
                }
            }
            next++;
        }
        return true;
    }
}
