class Solution {
public:
    vector<int>dp;

    bool canReach(string s, int minJump, int maxJump) {
        int n = s.length();
        dp.resize(n, -1);

        dp[n-1] = 1;

        if(s[n-1] == '1')
            return false;

        return dfs(0, s, minJump, maxJump, n);
    }
    bool dfs(int i, string &s, int& minJump, int& maxJump, int n){
        if(dp[i] != -1)
            return dp[i];

        dp[i] = 0;

        for(int j= i+minJump; j<= min(n-1, i+maxJump); j++){
            if(s[j] == '0' && dfs(j, s, minJump, maxJump, n)){
                dp[i] = 1;
                break;
            }
        }

        return dp[i];
    }
};