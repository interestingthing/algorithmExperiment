package binary_search_tree;

import java.util.Date;
import java.util.Random;

public class TestBST {
	public static void generateData(int[] nums){
		Random r = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt(1000000);
		}
	}
	
	public static void main(String[] args) {
		int count_rec = 0,count_it = 0;
		int i = 1;
		while(i < 11){
			System.out.println("------------------------------------------------------第"+i+"次测试-----------------------------------------");
			int[] nums = new int[1000000];
			generateData(nums);
			Date begin = new Date();
			TreeNode root = null;
			for (int j = 0; j < nums.length; j++) {
				root = BST.insertNodeRecursion(root, new TreeNode(nums[j]));
			}
			BST.iterator_inorder(root);
			Date end = new Date();
			TreeNode root1 = null;
			for (int j = 0; j < nums.length; j++) {
				root1 = BST.insertNodeIterative(root1, new TreeNode(nums[j]));
			}
			BST.iterator_inorder(root1);
			Date end1 = new Date();
			long rec = end.getTime()-begin.getTime();
			long it = end1.getTime()-end.getTime();
			System.out.println("insertNodeRecursion用了"+rec+"ms");
			System.out.println("insertNodeIterative用了"+it+"ms");
			if(rec < it){
				count_rec++;
				System.out.println("insertNodeRecursion快");
			}else{
				count_it++;
				System.out.println("insertNodeIterative快");			
			}
			System.out.println();
			i++;
		}
		System.out.println("insertNodeRecursion快了"+count_rec+"次");
		System.out.println("insertNodeIterative快了"+count_it+"次");
	}
}
