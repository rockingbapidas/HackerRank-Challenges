import java.util.*;

public class HackerRankHashMap {

    public static void main(String[] args) {
        // checkMagazine();
        // twoStrings();
        // sherlockAndAnagrams();
        // countTriplets();
        List<List<Integer>> list = new ArrayList<>();
        freqQuery(list);
    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> list = new ArrayList<>();
        return list;
    }

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> itemWithCount = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;

        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;

            if (counter.containsKey(key) && a % r == 0) {
                count += counter.get(key);
            }

            if (itemWithCount.containsKey(key) && a % r == 0) {
                long c = itemWithCount.get(key);
                counter.put(a, counter.getOrDefault(a, 0L) + c);
            }

            itemWithCount.put(a, itemWithCount.getOrDefault(a, 0L) + 1);
        }

        return count;
    }

    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String currentSubString = s.substring(i, j);

                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                if (map.containsKey(currentSubString)) {
                    int value = map.get(currentSubString);
                    totalCount = totalCount + value;

                    map.put(currentSubString, value + 1);
                } else {
                    map.put(currentSubString, 1);
                }
            }
        }
        return totalCount;
    }

    static String twoStrings(String s1, String s2) {
        boolean found = false;
        int a = 97;
        int az = a + 25;
        for (int i = a; i < az; i++) {
            if (s1.indexOf(i) != -1 && s2.indexOf(i) != -1) {
                found = true;
                break;
            }
        }
        if (found) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static void checkMagazine(String[] magazine, String[] note) {
        int count = 0;
        Hashtable<String, Integer> magazineWords = new Hashtable<String, Integer>();
        for (String s : magazine) {
            if (magazineWords.containsKey(s)) {
                magazineWords.put(s, magazineWords.get(s) + 1);
            } else {
                magazineWords.put(s, 1);
            }
        }
        outerloop: for (String s : note) {
            if (!magazineWords.containsKey(s)) {
                count++;
                break outerloop;
            }
            int counter = magazineWords.get(s) - 1;
            if (counter == 0) {
                magazineWords.remove(s);
            } else {
                magazineWords.put(s, counter);
            }
        }
        if (count > 0)
            System.out.println("No");
        else
            System.out.println("Yes");
    }
}