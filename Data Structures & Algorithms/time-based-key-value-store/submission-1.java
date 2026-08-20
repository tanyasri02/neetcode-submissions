class TimeMap {
    private Map<String, TreeMap<Integer, String>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, k-> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key))
            return "";

        for(int i=timestamp; i>=0; i--){
            if (mp.get(key).containsKey(i))
                return mp.get(key).get(i);
        }
        return "";
    }
}
