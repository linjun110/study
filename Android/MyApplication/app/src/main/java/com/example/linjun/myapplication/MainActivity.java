package com.example.linjun.myapplication;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendHttp1(View view) {
        InputStream is = null;
        try {
            URL urlObj = new URL("https://www.baidu.com");
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            is = urlConnection.getInputStream();
            int status = urlConnection.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(is));

            String result = "";
            String line = "";

            while (null != (line = bufferedReader.readLine()))
            {
                result += line;
            }

            // 将结果打印出来，可以在LogCat查看
            System.out.println(result);


            WebView webView = new WebView(this);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://www.baidu.com");

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(is != null){
                    is.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void sendHttp(View view) {
        WebView webView = new WebView(this);
        //webView.loadUrl("https://www.baidu.com");
        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                //handler.cancel(); // Android默认的处理方式
                handler.proceed();  // 接受所有网站的证书
                //handleMessage(Message msg); // 进行其他处理
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("gb2312");
        webView.loadUrl("https://192.168.1.107:8081/springMvcWeb/");
        setContentView(webView);
    }
}
