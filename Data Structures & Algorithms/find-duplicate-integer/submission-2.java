class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true){
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            if(slow == fast) break;
        }
        int slowNew = 0;
        while(true){
            slowNew = nums[slowNew];
            slow = nums[slow];
            if(slow == slowNew) break;
        }
        return slow;
    }
}
