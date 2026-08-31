
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i]<=nums2[j]){
                merged[index] = nums1[i];
                i++;
            }else{
                merged[index] = nums2[j];
                j++;
            }
            index++;
        }
        while(i<nums1.length){
            merged[index] = nums1[i];
            i++;
            index++;
        }
        while(j<nums2.length){
            merged[index] = nums2[j];
            j++;
            index++;
        }
        if(merged.length%2==0){
            int mid = (merged.length-1)/2;
            return (double)(merged[mid] + merged[mid+1])/2;
        }
        int mid = (merged.length-1)/2;
        return merged[mid];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
