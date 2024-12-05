/*
42. Trapping Rain Water
Hard
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int width = 1;
        int max_water = 0;
        int end = height.length;
        if (height.length <= 2) {
            return max_water;
        }
        int[] left_max_boundary = new int[end];
        int[] right_max_boundary = new int[end];
        left_max_boundary[0] = height[0];
        right_max_boundary[end - 1] = height[end - 1];
        for (int i = 1; i < end; i++) {
            if (height[i] <= left_max_boundary[i - 1]) {
                left_max_boundary[i] = left_max_boundary[i - 1];
            } else {
                left_max_boundary[i] = height[i];
            }
        }

        for (int i = end - 2; i >= 0; i--) {
            if (height[i] <= right_max_boundary[i + 1]) {
                right_max_boundary[i] = right_max_boundary[i + 1];
            } else {
                right_max_boundary[i] = height[i];
            }
        }

        int[] water_level = new int[end];
        water_level[0] = height[0];
        water_level[end - 1] = height[end - 1];
        for (int i = 1; i < end - 1; i++) {
            water_level[i] = Math.min(left_max_boundary[i], right_max_boundary[i]);
        }
        for (int i = 0; i < end; i++) {
            max_water += ((water_level[i] - height[i]) * width);
        }
        return max_water;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Test case 1
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Max trapped water (Test Case 1): " + solution.trap(height1)); // Expected output: 6

        // Test case 2
        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Max trapped water (Test Case 2): " + solution.trap(height2)); // Expected output: 9

        // Test case 3 (edge case: array too small)
        int[] height3 = { 1, 2 };
        System.out.println("Max trapped water (Test Case 3): " + solution.trap(height3)); // Expected output: 0

        // Test case 4 (edge case: array with no valleys)
        int[] height4 = { 3, 3, 3, 3 };
        System.out.println("Max trapped water (Test Case 4): " + solution.trap(height4)); // Expected output: 0
    }
}
