/*
1. Two Sum
Easy
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Indices for Test Case 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected output: [0,
                                                                                                 // 1]

        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Indices for Test Case 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected output: [1,
                                                                                                 // 2]

        // Test case 3
        int[] nums3 = { 1, 2, 3 };
        int target3 = 7;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Indices for Test Case 3: [" + result3[0] + ", " + result3[1] + "]"); // Expected output: [0,
                                                                                                 // 0] (no solution)
    }
}
