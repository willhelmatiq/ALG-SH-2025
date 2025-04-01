package org.shadhelper.Heap_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemD {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String keysAndDoors = bufferedReader.readLine();
        System.out.println(countExtraKeys(keysAndDoors));

    }

    static int countExtraKeys(String keysAndDoors) {
        int[] keysCount = new int[26];
        int count = 0;
        for (int i = 0; i < keysAndDoors.length(); i++) {
            if (keysAndDoors.charAt(i) >= 'a' && keysAndDoors.charAt(i) <= 'z') {
                char key = keysAndDoors.charAt(i);
                keysCount[key - 'a']++;
            } else {
                char door = keysAndDoors.charAt(i);
                int keyForDoorIndex = door - 'A';
                if (keysCount[keyForDoorIndex] > 0) {
                    keysCount[keyForDoorIndex]--;
                } else {
                    count++;
                }
            }
        }
        return count;
    }
}
