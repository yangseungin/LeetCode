class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        combination(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }


    public void combination(List<List<Integer>> result, ArrayList<Integer> integers, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            integers.add(candidates[i]);
            combination(result, integers, candidates, target - candidates[i], i);
            integers.remove(integers.size() - 1);
        }
    }
}