
/*
977.有序数组的平方
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 */

import java.util.Arrays;

public class Array03_Squares_Of_A_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        // 1.暴力
//         for(int i = 0;i<nums.length;i++) nums[i] *= nums[i];// 先遍历数组元素并求出其平方，放入原数组中
//        Arrays.sort(nums);//快速排序
        int start = 0;
        int end = nums.length - 1;

        int[] result = new int[nums.length];
        int index = result.length - 1;
        // 2.快慢指针(nums是按一定顺序排列的数组，最大平方数只能在两边取得)
        while (start <= end) {
            if (nums[start] * nums[start] < nums[end] * nums[end]) {
                result[index--] = nums[end] * nums[end];//若前面的元素平方和大，则添加到新数组的最后
                --end;
            } else {
                result[index--] = nums[start] * nums[start];//若后面元素的平方和大，则添加到新数组的到最后
                ++start;
            }
        }
        return result;
    }
}