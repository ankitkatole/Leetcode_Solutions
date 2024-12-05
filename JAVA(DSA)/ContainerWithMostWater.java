/*
11. Container With Most Water
Medium
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max_water = Integer.MIN_VALUE;
        int x = 0;
        int y = height.length - 1;
        while (x < y) {
            int h = Math.min(height[x], height[y]);
            int current_area = h * (y - x);
            if (current_area > max_water) {
                max_water = current_area;
            }
            if (height[x] < height[y]) {
                x++;
            } else {
                y--;
            }
        }
        return max_water;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println("Max area for Test Case 1: " + maxArea(height1)); // Expected output: 49

        // Test case 2
        int[] height2 = { 1, 1 };
        System.out.println("Max area for Test Case 2: " + maxArea(height2)); // Expected output: 1

        // Test case 3
        int[] height3 = { 4, 3, 2, 1, 4 };
        System.out.println("Max area for Test Case 3: " + maxArea(height3)); // Expected output: 16

        // Test case 4
        int[] height4 = { 1, 2, 1 };
        System.out.println("Max area for Test Case 4: " + maxArea(height4)); // Expected output: 2
    }
}
