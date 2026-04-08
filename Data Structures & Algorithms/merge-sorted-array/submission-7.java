class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1len = nums1.length - nums2.length - 1;
        int i = 0;
        int j = 0;
        if(nums2.length != 0){
            while(i<=nums1len){
            if(nums1[i]>=nums2[j]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                Arrays.sort(nums2);
            }
            i++;
        }
        j=0;
        System.out.println(nums1len);
        for(i = nums1len+1; i<nums1.length; i++){
            nums1[i] = nums2[j];
            j++;
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        }
        
    }
}