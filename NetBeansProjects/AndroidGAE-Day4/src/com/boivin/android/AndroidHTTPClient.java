/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boivin.android;

/**
 *
 * @author peterboivin
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
 
public class AndroidHTTPClient extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        TextView textView = (TextView)findViewById(R.id.outputTextView);
 
        RestClient client = new RestClient("http://192.168.1.102:8080/");
        client.AddParam("message", "I love my Boopsie");
 
        try
        {
            client.Execute(RequestMethod.GET);
        }
        catch (Exception e)
        {
            textView.setText(e.getMessage());
        }
 
        String response = client.getResponse();
        System.out.println("Response: " + response);
        textView.setText(response);
    }
}