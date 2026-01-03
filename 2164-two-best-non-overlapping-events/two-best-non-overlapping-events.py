class Solution(object):
    def maxTwoEvents(self, events):
        
        events.sort(key=lambda x: x[0])
        n = len(events)
        
        
        maxFrom = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            maxFrom[i] = max(maxFrom[i + 1], events[i][2])
        
        ans = 0
        
        for i in range(n):
            start, end, val = events[i]
            
            
            lo, hi = i + 1, n
            while lo < hi:
                mid = (lo + hi) // 2
                if events[mid][0] > end:
                    hi = mid
                else:
                    lo = mid + 1
            
            ans = max(ans, val + maxFrom[lo])
        
        return ans
