class Solution {
    public int reverse(int num) {
        long x = num;
        boolean negative = x < 0;
        if(negative)
            x = -x;

        long ans = 0;
        while(x > 0){
            long curr = x%10;
            ans = ans*10+curr;
            x = x/10;
        }

        if(negative)
            ans = -ans;

        if(ans > Integer.MAX_VALUE)
            return 0;

        if(ans < Integer.MIN_VALUE)
            return 0;

        return (int) ans;
    }
}
