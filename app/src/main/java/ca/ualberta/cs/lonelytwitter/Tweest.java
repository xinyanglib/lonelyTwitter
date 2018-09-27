package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Created by xinyang4 on 9/19/18.
 */

public abstract class Tweest {
    protected String message;
    protected Date date;
    public Tweest(String message)
    {
        this.message = message;
        this.date = new Date();

    }
    public Tweest(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public void setMessage(String message) throws TooLongTweetException
    {
        if (message.length()>140){
            throw new TooLongTweetException();
        }
        this.message = message;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public String getMessage()
    {
        return this.message;
    }
    public Date getDate()
    {
        return this.date;
    }

    public abstract boolean isImportant();

    public String toString()
    {
        return date.toString() + " | " + message;
    }
}
