class MedianFinder {
    ArrayList<Integer>arr;

    public MedianFinder() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        arr.add(num);
    }
    
    public double findMedian() {
        Collections.sort(arr);
        int n = arr.size();
        if((n& 1) == 1){
            return arr.get(n/2);
        }else{
            return (arr.get(n/2) + arr.get(n/2 -1)) / 2.0;
        }
    }
}
