/*
* No need to merge two arrays into one and then found the median. Both arrays are already sorted, so we can use two 'separators' to
* mark the mutual median in both arrays (the median when they are merged). Use binary search to boost search efficiency.
* Use hashset to improve read and write efficiency.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int i, j, m, n, median, l1, l2, r1, r2, lo, hi;
        m = nums1.length;
        n= nums2.length;
        if (n < m) return findMedianSortedArrays(nums2, nums1); //Guarantee binary search are always performed on smaller array.
        median = (m + n + 1) / 2;
        i = m / 2;
        lo = 0;
        hi = m; //Sentinel to mark the boundary of binary search.
        do{
            i = (hi + lo) / 2;
            j = median - i;
            l1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            l2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            r1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            r2 = (j == n) ? Integer.MAX_VALUE : nums2[j];
            if (l1 > r2){
                hi = i - 1;
            }else if (l2 > r1){
                lo = i + 1;
            }else if (l1 <= r2 && l2 <= r1) break;
        }while (lo <= hi);
        if ((m + n) % 2 == 0) result = (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        else result = Math.max(l1, l2);
        return result;
    }
}
