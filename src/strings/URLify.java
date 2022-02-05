package strings;

import java.util.Scanner;

public class URLify {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] c = s.toCharArray();
        int trueLength = s.trim().length();
        int spaces = 0;
        for(int i=0;i<trueLength;i++) {
            if(c[i] == ' ') spaces++;
        }

        int index = trueLength + spaces * 2;

        for(int i=trueLength-1;i>=0;i--) {
            if(c[i] == ' ') {
                c[index-1] = '0';
                c[index-2] = '2';
                c[index-3] = '%';
                index = index - 3;
            } else {
                c[index - 1] = c[i];
                index--;
            }
        }

        System.out.println(c);
    }
}
