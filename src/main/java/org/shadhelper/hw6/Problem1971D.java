package org.shadhelper.hw6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1971D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++){
            System.out.println(countPieces(bufferedReader.readLine()));
        }
    }

    static int countPieces(String s) {
        if (s.length() <= 1) {
            return 1;
        }

        int piecesCount = 1;
        char prevChar = s.charAt(0);
        boolean firstTransitionHandled = false;

        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != prevChar) {
                if (!firstTransitionHandled && prevChar == '0' && currentChar == '1') {
                    firstTransitionHandled = true;
                } else {
                    piecesCount++;
                }
                prevChar = currentChar;
            }
        }

        return piecesCount;
    }
}
