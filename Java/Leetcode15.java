import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        // 结果初始化
        List<List<Integer>> res = new ArrayList<>();

        // 先确定指针k，再移动 i，j
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0)
                break;
            if (k > 0 && nums[k] == nums[k - 1])
                continue;

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i])
                        ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j])
                        ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i])
                        ;
                    while (i < j && nums[j] == nums[--j])
                        ;
                }
            }
        }
        return res;
    }
}