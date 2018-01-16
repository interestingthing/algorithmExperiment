package binary_search;

import java.util.Random;

public class BinarySearch {
    /**
     * @param nums  The sorted integer array.
     * @param target  Target to find.
     * @return The first position of target. Position starts from 0.
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length;
        while (start < end) {
            // avoid overflow when (end + start)
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
        		return mid;
        	}else if(nums[mid] > target){
                end = mid-1;
            }else if (nums[mid] < target) {
                start = mid+1;
            }
        }
		return start;
    }
    
    /**
     *@param nums : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return result;

        int start = 0, end = nums.length;
        //lower bound
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid+1;
            }else {
            	end = mid-1;
            }
        }
        // whether A[start + 1] == target, check start + 1 first
        if ((start + 1 < nums.length) && (nums[start + 1] == target)) {
            result[0] = start + 1;
        } else {
            result[0] = -1;
            result[1] = -1;
            // target is not in the array
            return result;
        }

        // upper bound, since end >= start, we do not reset start
        end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
            	end = mid-1;
            } else {
            	start = mid+1;
            }
        }
        // target must exist in the array
        result[1] = end;
        return result;
    }
    
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null) {
            return false;
        }
        int ROW = matrix.length, COL = matrix[0].length;
        int lb = -1, ub = ROW * COL;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (matrix[mid / COL][mid % COL] < target) {
                lb = mid;
            } else {
                if (matrix[mid / COL][mid % COL] == target) {
                    return true;
                }
                ub = mid;
            }
        }
        return false;
    }
    /**
     * ±©Á¦ËÑË÷
     * @param nums  The sorted integer array.
     * @param target  Target to find.
     * @return The first position of target. Position starts from 0.
     */
    public static int BFSearch(int[] nums, int target){
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i] == target)
    			return i;
    	}
    	return -1;
    }
}
