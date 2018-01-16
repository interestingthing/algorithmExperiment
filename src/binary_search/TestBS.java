package binary_search;

import java.util.Date;
import java.util.Random;

public class TestBS {
	
	public static void generateData(int[] nums){
		Random r = new Random();
		int temp = r.nextInt(10);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp;
			temp += r.nextInt(10);
		}
	}
	public static void main(String[] args) {
		int[] nums = new int[10000000];
		generateData(nums);
		int count_bs = 0,count_bf = 0;
		int i = 1;
		while(i < 1000001){
			System.out.println("第"+i+"次测试");
			int target = new Random().nextInt(5000000);
			Date begin = new Date();
			BinarySearch.binarySearch(nums, target);
			Date bs_end = new Date();
			BinarySearch.BFSearch(nums, target);
			Date bf_end = new Date();
			long bf = bf_end.getTime()-bs_end.getTime();
			long bs = bs_end.getTime()-begin.getTime();
			System.out.println("BF用了"+bf+"ms");
			System.out.println("BS用了"+bs+"ms");
			if(bf < bs){
				count_bf++;
				System.out.println("暴力搜索快");
			}else{
				count_bs++;
				System.out.println("二分搜索快");			
			}
			System.out.println();
			i++;
		}
		System.out.println("暴力搜索快了"+count_bf+"次");
		System.out.println("二分搜索快了"+count_bs+"次");
	}
}
