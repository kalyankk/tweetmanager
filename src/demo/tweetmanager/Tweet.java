package demo.tweetmanager;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tweet {
    private static Pattern p = Pattern.compile("#([A-Za-z0-9-_]+)");

    private String tweetText;

    protected Tweet(String tweetText) {
        if(tweetText == null || tweetText.length()==0)
            throw new RuntimeException("Tweet cannot be empty");
        this.tweetText = tweetText;
    }

    public String getTweetText() {
        return tweetText;
    }

    public List<String> getTags() {
        List<String> tags = new LinkedList<>();
        Matcher m = p.matcher(tweetText);
        while (m.find()) {
            String tag = m.group();
            if (!tags.contains(tag))
                tags.add(tag);
        }
        return tags;
    }
}
