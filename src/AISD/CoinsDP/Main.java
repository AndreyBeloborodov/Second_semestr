package AISD.CoinsDP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] coins = {1, 5, 10, 20, 25, 50};
        int[][] dp = new int[sum + 1][0];
        for (int i = 1; i < sum + 1; i++) {
            int cur = Integer.MAX_VALUE;
            int flag = 0;
            for (int j = 0; j < 6; j++) {
                int c = coins[j];
                if (i - c < 0) break;
                if (cur > dp[i - c].length) {
                    flag = j;
                    cur = dp[i - c].length;
                }
            }
            int[] ans = new int[dp[i - coins[flag]].length + 1];
            for (int j = 0; j < dp[i - coins[flag]].length; j++) ans[j] = dp[i - coins[flag]][j];
            ans[ans.length - 1] = coins[flag];
            dp[i] = ans;
        }

        for (int c : dp[sum]) System.out.print(c + " ");

    }
}
