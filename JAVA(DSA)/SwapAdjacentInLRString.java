/*
777. Swap Adjacent in LR String
Medium
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string result, return True if and only if there exists a sequence of moves to transform start to result.

Example 1:
Input: start = "RXXLRXRXL", result = "XRLXXRRLX"
Output: true
Explanation: We can transform start to result following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX

Example 2:
Input: start = "X", result = "L"
Output: false
 
Constraints:
1 <= start.length <= 104
start.length == result.length
Both start and result will only consist of characters in 'L', 'R', and 'X'.
 */

 public class SwapAdjacentInLRString {
    public static boolean canTransform(String start, String result) {
        if (start.replace("X", "").length() != result.replace("X", "").length()) {
            return false;
        }
        if (!start.replace("X", "").equals(result.replace("X", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && result.charAt(j) == 'X') j++;

            if (i < n && j < n) {
                if (start.charAt(i) == 'L' && i < j) return false;
                if (start.charAt(i) == 'R' && i > j) return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        String start1 = "RXXLRXRXL";
        String result1 = "XRLXXRRLX";
        System.out.println("Can transform for Test Case 1: " + canTransform(start1, result1)); // Expected output: true

        // Test case 2
        String start2 = "X";
        String result2 = "X";
        System.out.println("Can transform for Test Case 2: " + canTransform(start2, result2)); // Expected output: true

        // Test case 3
        String start3 = "XXRXXL";
        String result3 = "XXLXXR";
        System.out.println("Can transform for Test Case 3: " + canTransform(start3, result3)); // Expected output: false

        // Test case 4
        String start4 = "RX";
        String result4 = "XR";
        System.out.println("Can transform for Test Case 4: " + canTransform(start4, result4)); // Expected output: false
    }
}
