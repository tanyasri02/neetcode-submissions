class Solution {
    public List<Integer> buildMergerArray(int[] nums1, int[] nums2){
        List<Integer>  ans = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i=0,j=0;

        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                ans.add(nums1[i]); i++;
            }
            else {
                ans.add(nums2[j]); j++;
            }
        }

        while(i<n)
            ans.add(nums1[i++]);
        
        while(j<m)
            ans.add(nums2[j++]);

        return ans;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergeArray = new ArrayList<>();

        mergeArray = buildMergerArray(nums1, nums2);

        int n = mergeArray.size();

        if(n%2 == 1)
            return mergeArray.get(n/2);

        int x = n/2, y= n/2-1;

        return (mergeArray.get(x) + mergeArray.get(y))/2.0;
    }
}
