# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def maxProduct(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        MOD = 10**9 + 7
        self.totalSum = 0
        self.maxProd = 0

        def dfsTotal(node):
            if not node:
                return
            self.totalSum += node.val
            dfsTotal(node.left)
            dfsTotal(node.right)

        def dfs(node):
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            subSum = left + right + node.val
            self.maxProd = max(self.maxProd, subSum * (self.totalSum - subSum))

            return subSum

        dfsTotal(root)
        dfs(root)
        return self.maxProd % MOD