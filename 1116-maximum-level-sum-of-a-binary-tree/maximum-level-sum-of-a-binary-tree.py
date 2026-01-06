# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxLevelSum(self, root):
        level = 1
        mx = float("-inf")
        q = deque()
        q.append(root)
        while q:
            size = len(q)
            sm = 0
            for _ in range(size):
                node =q.popleft()
                sm += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            if sm > mx:
                ans = level
                mx = sm
            level +=1 
        return ans


        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        