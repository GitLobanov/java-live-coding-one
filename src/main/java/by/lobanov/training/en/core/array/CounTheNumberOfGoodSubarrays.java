package by.lobanov.training.en.core.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Difficulty: medium
 * Number in Leetcode: 2537
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * Example 1:
 * Input: nums = [1,1,1,1,1], k = 10
 * Output: 1
 * Explanation: The only good subarray is the array nums itself.
 * Example 2:
 * Input: nums = [3,1,4,3,2,2,4], k = 2
 * Output: 4
 * Explanation: There are 4 different good subarrays:
 * - [3,1,4,3,2,2] that has 2 pairs.
 * - [3,1,4,3,2,2,4] that has 3 pairs.
 * - [1,4,3,2,2,4] that has 2 pairs.
 * - [4,3,2,2,4] that has 2 pairs.
 */
public class CounTheNumberOfGoodSubarrays {

    // remove from end, start

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{3,1,4,3,2,2,4}, 2));
        System.out.println(countGood(new int[]{1,1,1,1}, 10));
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>(); // Frequency map for the current window
        int pairCount = 0; // Number of valid pairs in the current window
        int left = 0; // Left boundary of the sliding window
        int result = 0; // Total number of good subarrays

        for (int right = 0; right < nums.length; right++) {
            // Add nums[right] to the window and update pairCount
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) >= 2) {
                pairCount += (freq.get(nums[right]) - 1); // Update pairs based on new frequency
            }

            // Shrink the window while pairCount >= k
            while (pairCount >= k) {
                result += nums.length - right; // All subarrays ending at 'right' are good
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) >= 1) {
                    pairCount -= freq.get(nums[left]); // Adjust pairCount when removing nums[left]
                }
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]); // Remove the entry if frequency drops to 0
                }
                left++; // Move the left boundary of the window
            }
        }

        return result;
    }
}
