class Solution {
    public int[] merge(int[] a, int[] b){
        int[] sorted = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                sorted[index] = a[i];
                i++;
            }
            else{
                sorted[index] = b[j];
                j++;
            }
            index++;
        }
        while(i<a.length){
            sorted[index] = a[i];
            i++;
            index++;
        }
        while(j<b.length){
            sorted[index] = b[j];
            j++;
            index++;
        }
        return sorted;
    }

    public int[] sortArray(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums,0,mid));
        int[] right = sortArray(Arrays.copyOfRange(nums,mid,nums.length));
        return merge(left,right);
    }
}