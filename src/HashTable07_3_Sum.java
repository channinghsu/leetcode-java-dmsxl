import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 三数之和
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
 */
public class HashTable07_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }
            // a重复去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // 找到三元组添加到结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // b去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // c去重
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // 找到答案时，双指针同时收缩
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
