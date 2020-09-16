package demo;

import demo.tweetmanager.Tweet;
import demo.tweetmanager.TweetManager;

import java.util.Random;

public class TweetManagerDemo {
    public static void main(String args[]) {
        TweetManager tMgr = new TweetManager();
        Random rand = new Random();

       for(int i=0; i<20000; i++) {
           tMgr.createTweet("This is a sample tweet #TweetManager with random #hashtag"+ rand.nextInt(100) +" and another random #hashtag"+rand.nextInt(100) + " to test TweetDemoApp");
       }


//       tMgr.printHashTagsWithCount();

       System.out.println(tMgr.getTop10Tweets());


    }
}
