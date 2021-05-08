package com.example.getpage;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLService {
    public static String getHTML(String path){
        try{
            URL url = new URL(path);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.setDoOutput(true);
            connect.setConnectTimeout(10000);
            connect.setReadTimeout(10000);
            int rescode = connect.getResponseCode();
            System.out.println(rescode);
            if(rescode == 200) {
                InputStream inputStream = connect.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append("\n");
                }
                if (builder.length() == 0) {
                    // Stream was empty. No point in parsing.
                    return null;
                }
                String pageSourceString = builder.toString();
                System.out.println(pageSourceString);
                return pageSourceString;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {

        }
        return "Hello";
    }
}
