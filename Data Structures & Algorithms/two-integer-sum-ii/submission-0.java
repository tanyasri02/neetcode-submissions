class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j = numbers.length-1;

        while(i < j){
            int curr = numbers[i] + numbers[j];
            if(curr > target)
                j--;
            else if(curr < target)
                i++;
            else 
                return new int[] {i+1, j+1};
        }

        return new int[0];
    }
}
