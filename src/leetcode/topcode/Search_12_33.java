package leetcode.topcode;

/**
 * @Description: 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *  在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 *  使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 *  例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *  给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 *  你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * @url: https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @Date: 2022/10/6
 * @Author: Zirui Wang
 */
public class Search_12_33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 3));
    }

    /**
     * 思路：数组一分为二，至少有一半为有序数组，目标数字要么在有序数组中，要么在另一半
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了27.54%的用户
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                    continue;
                }
                left = mid+1;
                continue;
            }
            if(nums[right] >= nums[mid]){
                if(target > nums[mid] && target <= nums[right]){
                    left = mid+1;
                    continue;
                }
                right = mid-1;
            }
        }
        return -1;
    }
}
