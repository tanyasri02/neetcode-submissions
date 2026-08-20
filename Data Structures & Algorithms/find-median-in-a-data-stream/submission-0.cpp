class MedianFinder {
public:
    vector<int>arr;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        arr.push_back(num);
    }
    
    double findMedian() {
        sort(arr.begin(), arr.end());
        int n = arr.size();
        double ans = 0.0;

        if(n%2 == 0){
            int i = n/2 - 1;
            int j = n/2;

            ans = (arr[i] + arr[j])/2.0;
            return ans;
        }else{
            ans = arr[n/2];
            return ans;
        }

        return ans;
    }
};
