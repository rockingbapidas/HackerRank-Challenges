import java.util.*;

public class HackerRankArrays {
    
    public static void main(String[] args) {
        hourglassSum(new int[][]{{1,2,4,5,6}, {2,3,5,6,7}});
    }

    static int hourglassSum(int[][] arr) {
        ArrayList<Integer> new_arr = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum = sum + arr[i + 1][j + 1];
                sum = sum + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                new_arr.add(sum);
            }
        }
        Collections.sort(new_arr);
        int hourglassSum = new_arr.get(new_arr.size() - 1);
        return hourglassSum;
    }

    static int[] rotLeft(int[] a, int d) {
        int lengthOfArray = a.length;
        int actualArray = lengthOfArray - d;
        int[] arr = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            int newLocation = (i + actualArray) % lengthOfArray;
            arr[newLocation] = a[i];
        }
        return arr;
    }

    static void minimumBribes(int[] q) {
        int count = 0;
        // always keep track of min three vlaues observed
        // Compare currently seeing value with this three values.
        int midOfThree = Integer.MAX_VALUE;
        int maxOfThree = Integer.MAX_VALUE;
        int minOfThree = Integer.MAX_VALUE;

        // iterating from left to right
        for (int i = q.length - 1; i >= 0; i--) {
            // person has no way to move more than two positions -> wrong
            if ((q[i] - i) > 3) {
                System.out.println("Too chaotic");
                return;
            } else {
                // means current value has passed at least 3 values -> wrong
                if (q[i] > maxOfThree) {
                    System.out.println("Too chaotic");
                    return;
                } else if (q[i] > midOfThree) { // means -> current value has bribed 2 ppl
                    count = count + 2;
                } else if (q[i] > minOfThree) { // means-> current value has bribed 1 person.
                    count = count + 1;
                }

                // Now adjust minThree values comparing, taking the current vlaue to account
                if (q[i] < minOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = minOfThree;
                    minOfThree = q[i];
                } else if (q[i] < midOfThree) {
                    maxOfThree = midOfThree;
                    midOfThree = q[i];
                } else if (q[i] < maxOfThree) {
                    maxOfThree = q[i];
                }
            }
        }
        System.out.println(count);
    }

    static int minimumSwaps(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length;) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }

    static long arrayManipulation(int n, int[][] queries) {
        long arr[] = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1] - 1;
            int k = queries[i][2];
            arr[a] += k;
            if (b + 1 < n) {
                arr[b + 1] -= k;
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(arr[i], max);
        }
        return max;
    }
}