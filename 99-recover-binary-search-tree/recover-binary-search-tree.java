class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        given(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void given(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        given(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        given(node.right);
    }
}