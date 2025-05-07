import java.util.*;

public class JavaHashSet {

    public class Solution {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            String [] pair_left = new String[t];
            String [] pair_right = new String[t];

            for (int i = 0; i < t; i++) {
                pair_left[i] = s.next();
                pair_right[i] = s.next();
            }

//Write your code here
            Set<String> hs = new HashSet<>();
            for(int i=0;i<t;i++){
                String[] arr = {pair_left[i],pair_right[i]};
                Arrays.sort(arr);
                String ns = arr[0] + "," + arr[1];
                if(!hs.contains(ns)) hs.add(ns);
                System.out.println(hs.size());
            }

        }
    }
}
