// https://leetcode.com/problems/two-sum/
// Solved the problem using HashMap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> tempMap= new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int sum = target-nums[i];
            if(tempMap.containsKey(sum)){
                return new int[] {tempMap.get(sum), i};
            }
            tempMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No match found!");
    }
}