package strings;

/*
Constraints:
Comparison is case sensitive.
Contains only 128 ASCII chars.
 */

public class CheckPermutation {
    public static void main(String[] args) {
        String s1 = "dog";
        String s2 = "god";

        System.out.println(checkPermutation(s1,s2));
    }

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] letters = new int[128];

        for(char ch: s1.toCharArray()) {
            letters[ch]++;
        }

        for(char ch:s2.toCharArray()) {
            letters[ch]--;
            if(letters[ch] < 0)
                return false;
        }

        return true;
    }
}
