package ca.ualberta.cs.lonelytwitter;

/**
 * Created by xinyang4 on 9/19/18.
 */

public class NormalTweest extends Tweest
{
    public NormalTweest(String message)
    {
        super(message);
    }
    public boolean isImportant(){
        return false;
    }
}
