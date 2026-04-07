class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        k = set(nums)
        if(len(k)<len(nums)):
            return True
        else:
            return False