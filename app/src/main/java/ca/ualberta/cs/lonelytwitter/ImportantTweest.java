package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by xinyang4 on 9/19/18.
 */

public class ImportantTweest extends Tweest
{
    public ImportantTweest(String message)
    {
        super(message);
    }
    public boolean isImportant(){
        return true;
    }
}
