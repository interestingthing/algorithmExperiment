package binary_search_tree;

import java.util.ArrayList;

public class BST {
	/**
	 *  Recursion
	 *  @param root: The root of the binary search tree.
	 *  @param node: insert this node into the binary search tree
	 *  @return: The root of the new binary search tree.
	 */
    public static TreeNode insertNodeRecursion(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (root.val > node.val) {
            root.left = insertNodeRecursion(root.left, node);
        } else {
            root.right = insertNodeRecursion(root.right, node);
        }
        return root;
    }
    
    /**
     * Iterative
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public static TreeNode insertNodeIterative(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) return node;
        if (node == null) return root;

        TreeNode rootcopy = root;
        while (root != null) {
            if (root.val <= node.val && root.right == null) {
                root.right = node;
                break;
            }
            else if (root.val > node.val && root.left == null) {
                root.left = node;
                break;
            }
            else if(root.val <= node.val) root = root.right;
            else root = root.left;
        }
        return rootcopy;
    }
    
    /**
     * Validate Binary Search Tree
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) 
        	return true;
        return helper1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper1(TreeNode root, long lower, long upper) {
        if (root == null) 
        	return true;
        // System.out.println("root.val = " + root.val + ", lower = " + lower + ", upper = " + upper);
        // left node value < root node value < right node value
        if (root.val >= upper || root.val < lower) return false;
        boolean isLeftValidBST = helper1(root.left, lower, root.val);
        boolean isRightValidBST = helper1(root.right, root.val, upper);
        return isLeftValidBST && isRightValidBST;
    }
    
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        helper2(root, k1, k2, result);
        return result;
    }

    private static void helper2(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if (root == null) return;
        // in-order binary tree iteration
        helper2(root.left, k1, k2, result);
        if (k1 <= root.val && root.val <= k2) {
            result.add(root.val);
        }
        helper2(root.right, k1, k2, result);
    }
    /**
     * 中序遍历输出
     * @param root 根节点
     */
    public static void iterator_inorder(TreeNode root){
    	if(root!=null){
    		if(root.left!=null)
    			BST.iterator_inorder(root.left);
    		System.out.println(root.val + " ");
    		if(root.right!=null)
    			BST.iterator_inorder(root.right);
    	}
    }
}
