package com.zeetcode.dp;

public class PaintFence {
	public int numWays(int n, int k) {
		int dp[] = { 0, k, k * k, 0 };
		if (n <= 2) {
			return dp[n];
		}
		for (int i = 2; i < n; i++) {
			// 递推式：第三根柱子要么根第一个柱子不是一个颜色，要么跟第二根柱子不是一个颜色
			dp[3] = (k - 1) * (dp[1] + dp[2]);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}
		return dp[3];
	}
}
