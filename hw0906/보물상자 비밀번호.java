import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//      StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++)
        {
            List<Integer> list = new ArrayList<Integer>();
            List<Integer> gg = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            // N은 4의 배수다 8 ~ 28 이하다
            String s = br.readLine();
 
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'F')
                {
                    int tt = s.charAt(i) - 'A';
                    gg.add(10 + tt);
                }
                else
            {
                gg.add(Integer.parseInt(s.charAt(i) + ""));
                }
            }
            // System.out.print(gg);
            int E = N / 4;
            for (int j = 0; j < E; j++)
            {
                int h = gg.get(0);
                for (int i = 1; i < s.length() + 1; i++) // 5개.
                {
                    if (i % E == 0)
                    {
                        if (!list.contains(h))
                        {
                            list.add(h);
                        }
                        h = 0;
                        if (i == N) break;
                    }
                    h *= 16;
                    h += gg.get(i);
                }
                int temp = gg.remove(N - 1);
                gg.add(0, temp);
            }
            Collections.sort(list);
            Collections.reverse(list);
            bw.write("#"+t+ " "+list.get(K-1) + "\n");
        }
        bw.flush(); 
        bw.close();
    }
}