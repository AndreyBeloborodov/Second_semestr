package AISD.Litcode_domachkaAISD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int ns = s.length(), nt = t.length();
        int[][] dp = new int[ns + 1][26];
        for (int i = 1; i < ns + 1; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j] + (s.charAt(i - 1) == ('a' + j) ? 1 : 0);
            }
        }
        int[] cur = new int[26];
        for (int i = 0; i < nt; i++) cur[t.charAt(i) - 'a']++;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < ns - nt + 1; i++) {
            boolean ok = true;
            for (int j = 0; j < 26 && ok; j++) ok &= (dp[i + nt][j] - dp[i][j] == cur[j]);
            if (ok) ans.add(i);
        }
        for (Integer c : ans) System.out.print(c + " ");

    }
}
