/*209. 长度最小的子数组
给定一个含有n个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
并返回其长度。如果不存在符合条件的子数组，返回 0 。
链接：https://leetcode.cn/problems/minimum-size-subarray-sum
输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
*/
public class Array04_Minimum_Size_Subarray_Sum {
    public int minSubArrayLenVoilent(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
            sum = 0;
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen(int[] nums, int target) {
        int sum = 0;
        int result = Integer.MAX_VALUE; // 结果
        int subLength;// 子串长度
        int start = 0; // 滑动窗口起始点
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                subLength = end - start + 1;
                result = Math.min(result, subLength);// 判断最终结果
                sum -= nums[start++];// 改变滑动窗口起始位置
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
