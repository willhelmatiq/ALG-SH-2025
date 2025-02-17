package org.shadhelper.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++){
            System.out.println(checkLine(bufferedReader.readLine()));
        }
    }

    static int checkLine(String s) {
        char previousSymbol = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == previousSymbol) {
                return 1;
            }
            previousSymbol = s.charAt(i);
        }
        return s.length();
    }
}
