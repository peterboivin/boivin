package com.boivin.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/** 
This is day five of my “five days of Android articles“. Today I’m going to modify yesterday’s example 
(Android: Using RestClient to communicate with Google App Engine) 
to access the Google App Engine project via a different way, a little more “bare bones” if you will. 
There is usually more than one way to do something so this article is to broaden the horizon bit. 
Personally I like the RestClient but today like I said is about a different approach.
*/
public class AndroidHTTPData extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView) findViewById(R.id.outputTextView);
 
        try
        {
            URL url = new URL("http://listenforrestclientboivin.appspot.com//?message=" + URLEncoder.encode("Hello Beautifuler","UTF-8"));
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
 
            // Get the HTTP response code
            if(httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream inputStream = httpConnection.getInputStream();
 
                if(inputStream != null)
                {
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
 
                    try
                    {
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(inputStream, "UTF-8"));
 
                        while ((line = reader.readLine()) != null)
                        {
                            stringBuilder.append(line).append("\n");
                        }
                    }
                    finally
                    {
                        inputStream.close();
                    }
                    textView.setText(stringBuilder.toString());
                }
 
            }
 
            if(httpConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
            {
                textView.setText("404 (not found)");
            }
        }
        catch (MalformedURLException urlEx)
        {
            textView.setText(urlEx.getMessage());
        }
        catch (IOException ioEx)
        {
            textView.setText(ioEx.getMessage());
        }
        catch (Exception ex)
        {
            textView.setText(ex.getMessage());
        }
    }
}
