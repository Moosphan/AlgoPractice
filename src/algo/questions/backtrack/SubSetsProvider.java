package algo.questions.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * e.g.
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * T(n) = 2^n
 * @since 2022/09/13
 */
public class SubSetsProvider {
    public List<List<Integer>> allSubSets(int[] numbers) {
        if (numbers.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, numbers, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int index, int[] numbers, List<Integer> subSet, List<List<Integer>> result) {
        if (index == numbers.length) {
            System.out.println("Output: " + subSet);
            result.add(new ArrayList<>(subSet));
        } else {
            // 每个元素都是两种选择：取/不取
            // 若不取，则跳过，执行下一个index元素
            dfs(index+1, numbers, subSet, result);
            // 若取，则加入子集，并开始下一个元素判断
            subSet.add(numbers[index]);
            dfs(index+1, numbers, subSet, result);
            // 遍历到叶子节点后，需要回溯到父节点
            subSet.remove(subSet.size() - 1);
        }
    }
}
