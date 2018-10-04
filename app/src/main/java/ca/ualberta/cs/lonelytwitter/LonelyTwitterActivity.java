/**
 * LonelyTwitterActivity class, to provide the UI of the application.
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<ImportantTweet> tweets = new ArrayList<ImportantTweet>();
	private ArrayAdapter<ImportantTweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				ImportantTweet newTweet = new ImportantTweet(text);
				tweets.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();


			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets =

		loadFromFile();
		adapter = new ArrayAdapter<ImportantTweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);

	}

	/**
	* load the file and to check of the file is that possible to use.
	 */

	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			Gson gson = new Gson();
			Type typeListTweets = new TypeToken<ArrayList<ImportantTweet>>(){}.getType();
			tweets = gson.fromJson(reader, typeListTweets);
			}

		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}
	/**
	 * save the information in the file.
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(tweets,writer);
            writer.flush();
            fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
            e.printStackTrace();
        }
    }
}