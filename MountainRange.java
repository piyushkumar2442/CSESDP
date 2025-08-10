import java.util.*;

public class MountainRange {
    static class Node {
        int height, index, dp;
        Node(int h, int i, int d) {
            height = h;
            index = i;
            dp = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        List<Node> stack = new ArrayList<>();
        int maxVisit = 1;

        for (int i = n - 1; i >= 0; i--) {
            int left = 0, right = stack.size() - 1;
            int maxChain = 1;

            // Binary search over the stack for valid glides
            while (left <= right) {
                int mid = (left + right) / 2;
                Node node = stack.get(mid);

                if (h[i] > node.height) {
                    maxChain = Math.max(maxChain, 1 + node.dp);
                    right = mid - 1; // try to go farther
                } else {
                    left = mid + 1;
                }
            }

            dp[i] = maxChain;
            stack.add(0, new Node(h[i], i, dp[i]));
            maxVisit = Math.max(maxVisit, dp[i]);
        }

        System.out.println(maxVisit);
    }
}

