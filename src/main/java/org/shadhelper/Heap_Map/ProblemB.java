package org.shadhelper.Heap_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ProblemB {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            bufferedReader.readLine();
            String[] params = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[][] heapMin = new int[m][3];
            int heapLength = m;
            for (int j = 0; j < m; j++) {
                int[] element = new int[3];
                String[] tokens = bufferedReader.readLine().split(" ");
                element[0] = Integer.parseInt(tokens[0]);
                element[1] = Integer.parseInt(tokens[1]);
                element[2] = j + 1;
                heapMin[m - j - 1] = element;
                siftDown(heapMin, m - j - 1, heapLength);
            }
            int[][] points = new int[2 * n][3];
            int sum = 0;
            for (int k = 0; k < n * 2; k++) {
                points[k] = takeTop(heapMin, heapLength);
                heapLength--;
                sum += points[k][1];
            }
            System.out.println(sum);
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            for (int k = 0; k < n; k++) {
                System.out.print(points[k][2] + " " + points[points.length - k - 1][2] + "\n");
            }
            System.out.println();
        }
    }

    static void siftUp(int[][] heapMin, int i, int heapLength) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heapMin[parent][1] >= heapMin[parent][1]) {
                break;
            }
            swap(heapMin, i, parent);
            i = parent;
        }

    }

    static void siftDown(int[][] heapMin, int i, int heapLength) {
        while (2 * i + 1 < heapLength) {
            int childInd = 2 * i + 1;
            if (2 * i + 2 < heapLength && heapMin[2 * i + 2][1] < heapMin[2 * i + 1][1]) {
                childInd = 2 * i + 2;
            }
            if (heapMin[i][1] <= heapMin[childInd][1]) {
                break;
            }
            swap(heapMin, i, childInd);
            i = childInd;
        }
    }

    static void swap(int[][] heapMin, int i, int j) {
        int[] temp = heapMin[i];
        heapMin[i] = heapMin[j];
        heapMin[j] = temp;
    }

    static int[] takeTop(int[][] heapMin, int heapLength) {
        int[] topElement = heapMin[0];
        heapMin[0] = heapMin[heapLength - 1];
        siftDown(heapMin, 0, heapLength - 1);
        return topElement;
    }
}
