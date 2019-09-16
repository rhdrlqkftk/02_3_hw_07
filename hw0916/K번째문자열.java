import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        ArrayList<String> array = new ArrayList<String>();
 
        for (int tc = 1; tc <= T; tc++) {
 
            array.clear();
 
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] split = new String[str.length()];
             
            for (int i = 0; i < str.length(); i++) {
                split[i] = str.substring(i);
            }
 
            Arrays.sort(split);
             
            여기 : for(int i=0; i<str.length(); i++) {
                for(int j=1; j<split[i].length()+1; j++) {
                    String temp = split[i].substring(0, j);
                    if(!array.contains(temp)) {
                        array.add(temp);
                    }
                    if(array.size() >= N) break 여기;
                }
            }
             
            if(array.size() < N) System.out.println("#" + tc + " none");
            else System.out.println("#" + tc + " " + array.get(N - 1));
        }
 
        br.close();
    }
}