package by.lobanov.training.en.core.leetcode.array;

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
public class TC8_CounTheNumberOfGoodSubarrays_Leetcode {

    public static void main(String[] args) {
        System.out.println(countGood(new int[]{3,1,4,3,2,2,4}, 2));
        System.out.println(countGood(new int[]{1,1,1,1,1}, 10));
    }

    public static long countGood(int[] A, int k) {
        long res = 0L;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i = 0, j = 0; j < A.length; ++j){
            k -= count.getOrDefault(A[j],0);
            count.put(A[j],count.getOrDefault(A[j],0)+1);
            // Or
            /*
            count.putIfAbsent(A[j],0);
            k -= count.get(A[j]);
            count.put(A[j],count.get(A[j])+1);
            */
            while(k <= 0){
                count.put(A[i],count.get(A[i])-1);
                k += count.get(A[i++]);
            }
            res += i;
        }
        return res;
    }
}
