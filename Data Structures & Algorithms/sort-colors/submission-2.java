class Solution {
    public int pivot(int[] nums, int first_index, int last_index) {
        int pivot_index = first_index;
        int swap_index = first_index;
        for (int i = pivot_index + 1; i <= last_index; i++) {
            if (nums[i] < nums[pivot_index]) {
                swap_index++;
                int temp = nums[i];
                nums[i] = nums[swap_index];
                nums[swap_index] = temp;
            }
        }
        int temp = nums[swap_index];
        nums[swap_index] = nums[pivot_index];
        nums[pivot_index] = temp;
        return swap_index;
    }

    public void quicksort(int[] nums, int first_index, int last_index) {
        if (first_index < last_index) {
            int pivot = pivot(nums, first_index, last_index);
            quicksort(nums, first_index, pivot - 1);
            quicksort(nums, pivot + 1, last_index);
        }
    }

    public void sortColors(int[] nums) {
        quicksort(nums,0,nums.length-1);
    }
}