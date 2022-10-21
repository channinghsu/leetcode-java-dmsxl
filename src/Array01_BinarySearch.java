/*704. 二分查找
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* https://leetcode.cn/problems/binary-search/
* */
public class Array01_BinarySearch {
    int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while(start < end){
            int middle = (start + end) / 2;
            if(nums[middle] < target){
                start = middle + 1;
            } else if (nums[middle] > target) {
                end = middle;
            }else {
                return middle;
            }
        }
        return -1;
    }
}