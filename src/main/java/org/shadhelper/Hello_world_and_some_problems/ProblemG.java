package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemG {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] params = bufferedReader.readLine().split(" ");
            int k = Integer.parseInt(params[1]);
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(countScore(numbers, k));
        }
    }

    static int countScore(int[] numbers, int k) {
        Arrays.sort(numbers);
        int l = 0;
        int r = numbers.length - 1;
        int score = 0;
        while (l < r) {
            if (numbers[l] + numbers[r] < k) {
                l++;
            } else if (numbers[l] + numbers[r] > k) {
                r--;
            } else {
                score++;
                l++;
                r--;
            }
        }
        return score;
    }
}
