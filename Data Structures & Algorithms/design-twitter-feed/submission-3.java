class User{
    int userId;
    Set<Integer>followee;
    PriorityQueue<Post>posts;

    public User(int userId){
        this.userId = userId;
        this.followee = new HashSet<>();
        this.posts = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));
    }
}

class Post{
    int userId;
    int tweetId;
    long time;

    public Post(int userId, int tweetId, long time){
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
}

class Twitter {
    Map<Integer, User> userMap;
    long time=0;
    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        User user = userMap.get(userId);
        if(user.posts.size() == 10){
            user.posts.remove();
        }
        user.posts.add(new Post(userId, tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Post> feed = new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));

        User user = userMap.get(userId);
        user.posts.forEach(p -> feed.add(p));
        user.followee.forEach(a-> userMap.get(a).posts.forEach(p -> feed.add(p)));

        while(feed.size() > 10){
            feed.remove();
        }

        while(!feed.isEmpty()){
            ans.add(feed.remove().tweetId);
        }

        Collections.reverse(ans);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        User currFollower = userMap.get(followerId);
        currFollower.followee.add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));

        User currFollower = userMap.get(followerId);
        currFollower.followee.remove(followeeId);
    }
}
