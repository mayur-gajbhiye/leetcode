/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {

    int[] nums1;
    int[] nums2;
    int[] array;
    int ptr = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.array = new int[nums1.length + nums2.length];
        mergeArrays(0, 0);
        if (array.length % 2 == 0) {
            return (double) (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
        } else {
            return array[array.length / 2];
        }
    }

    private void mergeArrays(int i1, int i2) {
        if (ptr >= array.length)
            return;
        if (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                array[ptr++] = nums1[i1];
                array[ptr++] = nums2[i2];
                mergeArrays(++i1, ++i2);
            } else if (nums1[i1] < nums2[i2]) {
                array[ptr++] = nums1[i1];
                mergeArrays(++i1, i2);
            } else {
                array[ptr++] = nums2[i2];
                mergeArrays(i1, ++i2);
            }
        } else {
            oneReachedEnd(i1, i2);
        }
    }

    private void oneReachedEnd(int i1, int i2) {
        if (ptr < array.length) {
            if (i1 == nums1.length) {
                while (i2 < nums2.length) {
                    array[ptr++] = nums2[i2++];
                }
            } else if (i2 == nums2.length) {
                while (i1 < nums1.length) {
                    array[ptr++] = nums1[i1++];
                }
            }
        }
    }
}
// @lc code=end
