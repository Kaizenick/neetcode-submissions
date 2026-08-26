
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
//        ------------------ O(n) --------------------
//        for(int i = 0; i<nums.length; i++){
//            if(nums[i]==target){
//                return i;
//            }
//        }
//        return -1;

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {

            int mid = (i + j) / 2;
            if(nums[mid] == target){
                return mid;
            }

            else if (nums[mid] <= nums[j]) {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
