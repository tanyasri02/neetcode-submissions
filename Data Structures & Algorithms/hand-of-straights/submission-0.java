class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for(int h : hand){
            mp.put(h, mp.getOrDefault(h, 0) + 1);
        }

        while(!mp.isEmpty()){
            int curr = mp.firstKey();

            for(int i=0;i<groupSize;i++){
                int ele = curr+i;

                if(!mp.containsKey(ele)){
                    return false;
                }

                mp.put(ele, mp.get(ele) - 1);

                if(mp.get(ele) == 0)
                    mp.remove(ele);
            }
        }

        return true;
    }
}
