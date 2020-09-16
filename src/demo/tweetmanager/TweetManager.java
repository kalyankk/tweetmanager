package demo.tweetmanager;

import java.util.*;

public class TweetManager {

    List<Tweet> allTweets;
    HashMap<String, HashTag> allHashTags;
    SortedSet<HashTag> sortedHashTags;

    public TweetManager() {
        allTweets = new LinkedList<>();
        allHashTags = new HashMap<>();
        sortedHashTags = new TreeSet<>();
    }

    public void createTweet(String tweetText) {
        Tweet tweet = new Tweet(tweetText);
        allTweets.add(tweet);

        for(String tag : tweet.getTags()) {
            HashTag hashTag = allHashTags.get(tag);
            if(hashTag==null) {
                hashTag = new HashTag(tag);
                allHashTags.put(tag, hashTag);
            }
            else {
                sortedHashTags.remove(hashTag);
            }
            hashTag.addTweet(tweet);
            sortedHashTags.add(hashTag);
        }


    }

    public List<String> getTop10Tweets() {
        List<String> topTags = new ArrayList<>();

        Iterator<HashTag> hashTagsItr = sortedHashTags.iterator();
        for(int i=0; hashTagsItr.hasNext() && i<10; i++)
            topTags.add(hashTagsItr.next().getTag());
        return topTags;

    }

    public List<Tweet> getAllTweets() {
        return Collections.unmodifiableList(allTweets);
    }

    public List<Tweet> getAllTweets(String tag) {
        HashTag hashTag = allHashTags.get(tag);
        if(hashTag==null)
            return Collections.unmodifiableList(new ArrayList<>());
        return hashTag.getAssociatedTweets();
    }


    public void printHashTagsWithCount() {
        Iterator<HashTag> hashTagsItrTemp = sortedHashTags.iterator();
        while(hashTagsItrTemp.hasNext()) {
            HashTag hashTag = hashTagsItrTemp.next();
            System.out.println(hashTag.getTag() + " -> " + hashTag.getTweetCount());
        }
    }

}
