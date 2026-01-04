class Solution(object):
    def sumFourDivisors(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total = 0

        for n in nums:
            count = 0
            s = 0
            d = 1

            while d * d <= n:
                if n % d == 0:
                    other = n // d
                    count += 1
                    s += d

                    if other != d:
                        count += 1
                        s += other

                    if count > 4:
                        break
                d += 1

            if count == 4:
                total += s

        return total
