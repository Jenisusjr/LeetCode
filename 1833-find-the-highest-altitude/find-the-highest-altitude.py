class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        op = [0]+list(accumulate(gain))
        if max(op) < 0:
            return 0
        return max(op)
        