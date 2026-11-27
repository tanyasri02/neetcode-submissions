class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;

        for(int[] triple : triplets){
            if(triple[0] > target[0] || triple[1] > target[1] || triple[2] > target[2])
                continue;

            if(triple[0] == target[0]) x = true;
            if(triple[1] == target[1]) y = true;
            if(triple[2] == target[2]) z = true;
        }

        return x && y && z;
    }
}
