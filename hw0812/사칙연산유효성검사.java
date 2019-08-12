import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        boolean flag;
 
        for (int t = 1; t < 11; t++) {
            int result = 0;
            int size = sc.nextInt();
            sc.next();
            for (int i = 0; i < size; i++) {
                String[] str = sc.nextLine().split(" ");
 
                if (i < size / 2) {
                    if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
                        result = 1;
                    } else {
                        result = 0;
                    }
                } else {
                    if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
                        result = 0;
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
 
}