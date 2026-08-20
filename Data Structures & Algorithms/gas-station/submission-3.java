class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currFuel = 0, totalFuel = 0, start = 0;

        for(int i=0;i<gas.length;i++){
            currFuel += gas[i] - cost[i];

            if(currFuel < 0){
                totalFuel += currFuel;
                currFuel = 0;
                start = i+1;
            }
        }

        if(currFuel+ totalFuel >= 0)
            return start;

        return -1;
    }
}
