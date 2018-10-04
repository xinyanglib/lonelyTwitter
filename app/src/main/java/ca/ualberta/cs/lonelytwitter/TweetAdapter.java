package ca.ualberta.cs.lonelytwitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apple on 2018/9/26.
 */

/**
 * it is get the information to store it in the array.
 */
public class TweetAdapter extends ArrayAdapter
{
    final public int resourceId;
    public TweetAdapter(Context context, int resourceId, List<ImportantTweet> list)
    {
        super(context, resourceId, list);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);

        Tweest tweest = (Tweest) getItem(position);

        TextView textView = (TextView) view.findViewById(R.id.listText);
        if(tweest!=null)

            textView.setText(tweest.getDate().toString() + "|" + tweest.getMessage());

        return view;
    }
}
