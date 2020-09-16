package demo.tweetmanager;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HashTag implements Comparable<HashTag>{
    private String tag;
    private List<Tweet> associatedTweets;

    protected HashTag(String hashTag) {
        if(hashTag == null || hashTag.length()==0)
            throw new RuntimeException("HashTag cannot be empty");
        this.tag = hashTag;

        associatedTweets = new LinkedList<>();
    }

    public String getTag() {
        return tag;
    }

    protected void addTweet(Tweet tweet) {
        if(tweet == null)
            throw new RuntimeException("Tweet cannot be null");
        associatedTweets.add(tweet);
    }

    public List<Tweet> getAssociatedTweets() {
        return Collections.unmodifiableList(associatedTweets);
    }

    public int getTweetCount() {
        return associatedTweets.size();
    }

    @Override
    public int compareTo(HashTag other) {
        return other.getTweetCount() - this.getTweetCount();
    }

}
