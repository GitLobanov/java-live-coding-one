package by.lobanov.training.en.core.array;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 * <br>
 * Example 1:
 * <br>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * <br>
 * Explanation: There are 8 negatives number in the matrix.
 * <br>
 * Example 2:
 * <br>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * <br>
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class TC6_en_CountNegativeNumbersInASortedMatrix_Leetcode {

    public static void main(String[] args) {
        // expected 8
        int[][] test1 = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };

        // expected 0
        int[][] test2 = {
                {3, 2},
                {1, 0},
        };

        // with for
        System.out.println(countNegatives(test1));
        System.out.println(countNegatives(test2));

        // with while
        System.out.println(countNegativesWithWhile(test1));
        System.out.println(countNegativesWithWhile(test2));
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countNegativesWithWhile(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
        while (r >= 0 && c < n) {
            if (grid[r][c] < 0) {
                --r;
                cnt += n - c;
            }else {
                ++c;
            }
        }
        return cnt;
    }
}
