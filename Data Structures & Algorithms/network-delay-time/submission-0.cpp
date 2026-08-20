class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<pair<int, int>>graph[101];

        for(auto &time: times){
            int u = time[0];
            int v = time[1];
            int dis = time[2];

            graph[u].push_back({v, dis});
        }
        queue<int>q;

        q.push(k);

        vector<int>distance(n+1, INT_MAX);
        distance[k] = 0;
        
        while(!q.empty()){
            int curr = q.front();
            q.pop();

            for(auto& neig : graph[curr]){
                int v = neig.first;
                int weight = neig.second;

                int currweight = distance[curr] + weight;

                if(distance[v] > currweight){
                    distance[v] = currweight;
                    q.push(v);
                }
            }
        }

        int ans = 0;

        for(int i=1;i<=n;i++){
            ans = max(ans, distance[i]);
        }

        return ans == INT_MAX? -1 : ans;
    }
};
