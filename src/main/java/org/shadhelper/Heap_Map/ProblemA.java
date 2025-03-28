package org.shadhelper.Heap_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemA {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] cards = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            HeapMax heapMax = new HeapMax(new int[cards.length]);
            System.out.println(calcMaxPoints(cards, heapMax));
        }
    }

    static long calcMaxPoints(int[] cards, HeapMax heapMax) {
        long sum = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] > 0) {
                heapMax.addElement(cards[i]);
            } else {
                if (!heapMax.isEmpty()){
                    sum += heapMax.takeHead();
                }
            }
        }
        return sum;
    }

    static class HeapMax {
        int[] heapArr;
        int length;

        HeapMax(int[] heapArr) {
            this.heapArr = heapArr;
            this.length = 0;
        }

        void siftDown(int i) {
            while (2 * i + 1 < length) {
                int childInd = 2 * i + 1;
                if (2 * i + 2 < heapArr.length && heapArr[2 * i + 2] > heapArr[2 * i + 1]) {
                    childInd = 2 * i + 2;
                }
                if (heapArr[i] >= heapArr[childInd]) {
                    break;
                }
                swap(heapArr, i, childInd);
                i = childInd;
            }

        }

        void siftUp(int i) {
            while (i-1 >= 0) {
                int parent = (i - 1) / 2;

                if (heapArr[i] <= heapArr[parent]) {
                    break;
                }
                swap(heapArr, i, parent);
                i = parent;
            }
        }

        void swap(int[] heapArr, int firstNode, int secondNode) {
            int tempVal = heapArr[firstNode];
            heapArr[firstNode] = heapArr[secondNode];
            heapArr[secondNode] = tempVal;
        }

        void addElement(int element) {
            heapArr[length] = element;
            length++;
            siftUp(length - 1);
        }

        int takeHead() {
            int head = heapArr[0];
            heapArr[0] = heapArr[length - 1];
            length--;
            siftDown(0);
            return head;
        }

        boolean isEmpty() {
            return length == 0;
        }
    }
}
