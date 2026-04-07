class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int i:nums){
            h1.put(i,h1.getOrDefault(i,0)+1);
        }
        for(int i:h1.values()){
            if(i>1){
                return true;
            }
        }
        return false;
}
}