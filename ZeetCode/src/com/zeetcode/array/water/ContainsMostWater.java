package com.zeetcode.array.water;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainsMostWater {
	public int maxArea(int[] height) {
        if (height == null || height.length < 2)    return 0;
        
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        int area;
        while (i < j) {
            area = Math.min(height[i], height[j]) * (j-i);
            maxArea = Math.max(maxArea, area);
            
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return maxArea;
    }
}