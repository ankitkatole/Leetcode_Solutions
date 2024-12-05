/*
2337. Move Pieces to Obtain a String
Medium
You are given two strings start and target, both of length n. Each string consists only of the characters 'L', 'R', and '_' where:
The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left, and a piece 'R' can move to the right only if there is a blank space directly to its right.
The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.

 Example 1:
Input: start = "_L__R__R_", target = "L______RR"
Output: true
Explanation: We can obtain the string target from start by doing the following moves:
- Move the first piece one step to the left, start becomes equal to "L___R__R_".
- Move the last piece one step to the right, start becomes equal to "L___R___R".
- Move the second piece three steps to the right, start becomes equal to "L______RR".
Since it is possible to get the string target from start, we return true.

Example 2:
Input: start = "R_L_", target = "__LR"
Output: false
Explanation: The 'R' piece in the string start can move one step to the right to obtain "_RL_".
After that, no pieces can move anymore, so it is impossible to obtain the string target from start.

Example 3:
Input: start = "_R", target = "R_"
Output: false
Explanation: The piece in the string start can move only to the right, so it is impossible to obtain the string target from start.
 
Constraints:
n == start.length == target.length
1 <= n <= 105
start and target consist of the characters 'L', 'R', and '_'.
*/

public class MovePiecesToObtainString {
    public static boolean canChange(String start, String target) {
        if (start.replace("_", "").length() != target.replace("_", "").length()) {
            return false;
        }
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

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
        String start1 = "R_L_";
        String target1 = "__LR";
        System.out.println("Can change for Test Case 1: " + canChange(start1, target1)); // Expected output: true

        // Test case 2
        String start2 = "R_L_";
        String target2 = "_RL_";
        System.out.println("Can change for Test Case 2: " + canChange(start2, target2)); // Expected output: false

        // Test case 3
        String start3 = "_R_";
        String target3 = "__R";
        System.out.println("Can change for Test Case 3: " + canChange(start3, target3)); // Expected output: true

        // Test case 4
        String start4 = "L__R";
        String target4 = "R__L";
        System.out.println("Can change for Test Case 4: " + canChange(start4, target4)); // Expected output: false
    }
}
