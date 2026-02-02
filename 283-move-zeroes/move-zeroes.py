class Solution(object):
    def moveZeroes(self, nums):

        non_zero = 0  # Pointer for non-zero elements
        
        # Move all non-zero elements to the front
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[non_zero] = nums[non_zero], nums[i]
                non_zero += 1
        