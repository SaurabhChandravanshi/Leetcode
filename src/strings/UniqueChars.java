package strings;
/*
Constraints & Assumption:
String is ASCII (128 chars)
 */
public class UniqueChars {

    public static void main(String[] args) {
        String s1 = "Saurabh";
        String s2 = "BigBytes";
        String s3 = "Alphabets";

        System.out.println(isUnique(s1));
        System.out.println(isUnique(s2));
        System.out.println(isUnique(s3));
    }

    public static boolean isUnique(String s) {

        if(s.length() > 128) {
            return false;
        }
        boolean[] chars = new boolean[128];

        for(int i=0;i<s.length();i++) {
            int ch =  s.charAt(i);

            if(chars[ch]) {
                return false;
            }
            chars[ch] = true;
        }
        return true;
    }
}

