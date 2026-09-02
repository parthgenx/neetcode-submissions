class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(result,curr,0,nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int start, int[] nums) {
        result.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            
            curr.add(nums[i]);
            backtrack(result,curr,i+1,nums);
            curr.remove(curr.size()-1);
        }
    }
}