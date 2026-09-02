//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//       ----------------  O(m + n) ----------------------------
//        int[] merged = new int[nums1.length + nums2.length];
//        int i = 0;
//        int j = 0;
//        int index = 0;
//        while (i < nums1.length && j < nums2.length) {
//            if(nums1[i]<=nums2[j]){
//                merged[index] = nums1[i];
//                i++;
//            }else{
//                merged[index] = nums2[j];
//                j++;
//            }
//            index++;
//        }
//        while(i<nums1.length){
//            merged[index] = nums1[i];
//            i++;
//            index++;
//        }
//        while(j<nums2.length){
//            merged[index] = nums2[j];
//            j++;
//            index++;
//        }
//        if(merged.length%2==0){
//            int mid = (merged.length-1)/2;
//            return (double)(merged[mid] + merged[mid+1])/2;
//        }
//        int mid = (merged.length-1)/2;
//        return merged[mid];

//        ---------------- O(log(n)) ----------------------------

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;
        int totalElementsOnLeft = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = totalElementsOnLeft - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
