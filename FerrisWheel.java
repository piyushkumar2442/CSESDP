import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        // Fast input using BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // number of people
        int x = Integer.parseInt(st.nextToken()); // max weight per gondola
        
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        // Sort weights for two-pointer pairing
        Arrays.sort(weight);

        int i = 0, j = n - 1;
        int gondolas = 0;

        // Two-pointer greedy logic
        while (i <= j) {
            if (weight[i] + weight[j] <= x) {
                i++; // lightest person paired
            }
            j--; // heaviest person always goes
            gondolas++;
        }

        System.out.println(gondolas);
    }
}
