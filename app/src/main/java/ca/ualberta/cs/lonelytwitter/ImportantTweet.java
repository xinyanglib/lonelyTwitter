package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by xinyang4 on 9/19/18.
 */

/**
 * to turn if it is the Important Twitter.
 */
public class ImportantTweet extends Tweest
{
    public ImportantTweet(String message)
    {
        super(message);
    }
    public boolean isImportant(){
        return true;
    }
}
