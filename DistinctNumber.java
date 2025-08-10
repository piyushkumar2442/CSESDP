import java.io.*;
import java.util.*;

public class DistinctNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Use file if needed
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(arr[i]));
        }

        System.out.println(set.size());
    }
}
