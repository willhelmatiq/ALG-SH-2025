package org.shadhelper.Hello_world_and_some_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemC {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            bufferedReader.readLine();
            int[] clocks = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            checkClocks(clocks);
        }
    }

    static void checkClocks (int[] clocks) {
        boolean isInfinityGame = true;
        for (int i = 0; i < clocks.length; i++) {
            if ((clocks[i] <= (i * 2)) || (clocks[i] <= ((clocks.length - 1 - i) * 2))) {
                isInfinityGame = false;
            }
        }
        System.out.println(isInfinityGame ? "YES" : "NO");
    }
}
