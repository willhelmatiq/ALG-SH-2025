package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemE {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(calcMaxPoints(numbers));
        }
    }

    static int calcMaxPoints(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int points;
        if (odd == 0) {
            points = 1;
        } else if (even == 0) {
            points = odd - 1;
        } else {
            points = odd + 1;
        }
        return points;
    }
}
