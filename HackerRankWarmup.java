import java.util.*;
import java.util.regex.*;

public class HackerRankWarmup {

    public static void main(String[] args) {
        sockMerchant(3, new int[]{1,2,3,4,5});
    }

    static int sockMerchant(int n, int[] ar) {
        Set<Integer> colors = new HashSet<Integer>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                result++;
                colors.remove(ar[i]);
            }
        }
        return result;
    }

    static int countingValleys(int n, String s) {
        int result = 0; // # of valleys
        int lvl = 0; // current level
        for (char c : s.toCharArray()) {
            if (c == 'U')
                ++lvl;
            if (c == 'D')
                --lvl;

            // if we just came UP to sea level
            if (lvl == 0 && c == 'U')
                ++result;
        }
        return result;
    }

    static int jumpingOnClouds(int n, int[] c) {
        int size = c.length;
        int count = -1;
        for (int i = 0; i < size; i++, count++) {
            if (i < size - 2 && c[i + 2] == 0)
                i++;
        }
        return count;
    }

    static long repeatedString(long n, String s) {
        Matcher matcher = Pattern.compile(String.valueOf('a')).matcher(s);
        int aInInput = 0;
        while (matcher.find()) {
            aInInput++;
        }
        long totalA = 0L;
        if (s.equals("a")) {
            totalA = n;
        } else {
            totalA = totalA + ((n / s.length()) * aInInput);
            for (int i = 0; i < (n % s.length()); i++) {
                if (s.charAt(i) == 'a') {
                    totalA++;
                }
            }
        }
        return totalA;
    }
}