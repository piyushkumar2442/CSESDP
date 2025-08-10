import java.util.*;

public class LIS {
    static int longestIncreasingSubsequence(int[] arr, int n) {
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;  // Minimum LIS length is 1 (first element)

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);
                if (ind < 0) {
                    ind = -ind - 1;
                }
                temp.set(ind, arr[i]);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();            // Number of elements
        int[] arr = new int[n];          // Array of elements

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();       // Input the array
        }

        System.out.println(longestIncreasingSubsequence(arr, n));
    }
}
