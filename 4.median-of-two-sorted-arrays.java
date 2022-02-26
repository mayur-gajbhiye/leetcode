/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int l1 = 0;
        int l2 = 0;

        int size = nums1.length + nums2.length;
        int[] arr = new int[size];
        while (i < size) {
            if (nums1[l1] < nums2[l2]) {
                arr[i++] = nums1[l1++];
                if (l1 == nums1.length - 1) {
                    while (l2 < nums2.length) {
                        arr[i++] = nums2[l2++];
                    }
                    break;
                }
                // i++;
                // l1++;
            } else if (nums2[l2] < nums1[l1]) {
                arr[i++] = nums2[l2++];
                if (l2 == nums2.length - 1) {
                    while (l1 < nums1.length) {
                        arr[i++] = nums1[l1++];
                    }
                    break;
                }
                // i++;
                // l2++;
            } else {
                arr[i++] = nums1[l1];
                arr[i++] = nums2[l2];
            }
            if (i > size + 1 / 2)
                break;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);
        }

        if (size % 2 != 0)
            return (double) arr[size / 2];

        double mid = arr[size / 2];
        double midNext = arr[(size / 2) + 1];
        return (mid + midNext) / 2;
    }
}
// @lc code=end
