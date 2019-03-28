package com.linjun.java.htmlUnitTest;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        actLikeHuman();
    }
    private static void actLikeHuman2Baidu(){
        try {
            // access
            final WebClient webClient = new WebClient();
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);

            HtmlPage page = webClient.getPage("https://www.baidu.com/");

            // login
            HtmlTextInput keyword = (HtmlTextInput) page.getElementById("kw");
            keyword.type("linjun");
            HtmlSubmitInput submit = (HtmlSubmitInput) page.getElementById("su");
            HtmlPage nextPage = submit.click();


            System.out.println(nextPage.getBaseURL());
            System.out.println(nextPage.asXml());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private static void actLikeHuman(){
        try {
            // access
            final WebClient webClient = new WebClient(BrowserVersion.CHROME);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setTimeout(600000);

            HtmlPage page = webClient.getPage("https://app.seoclarity.net/index.jsp");

            // login
            HtmlTextInput email = (HtmlTextInput) page.getElementById("email");
            email.setText("moyang@amazon.com");
            HtmlPasswordInput passwd = (HtmlPasswordInput) page.getElementById("password");
            passwd.setText("bUxH8e40");
            //Page nextPage = page.executeJavaScript("$('#loginBtn').click()").getNewPage();
            HtmlButton login = (HtmlButton) page.getElementById("loginBtn");
            HtmlPage nextPage = login.click();


            //System.out.println(nextPage.getWebResponse().getContentAsString());
            System.out.println(nextPage.getBaseURL());
            //System.out.println(nextPage.asXml());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    private static void directSend(){
        URL url = null;
        try {
            final WebClient webClient = new WebClient();
            url = new URL("https://app.seoclarity.net/j_spring_security_check");
            WebRequest requestSettings = new WebRequest(url, HttpMethod.POST);
            //requestSettings.setAdditionalHeader("Host", "app.seoclarity.net");
            //requestSettings.setAdditionalHeader("Connection", "keep-alive");
            //requestSettings.setAdditionalHeader("Cache-Control", "max-age=0");
            //requestSettings.setAdditionalHeader("Upgrade-Insecure-Requests", "1");
            //requestSettings.setAdditionalHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36");
            //requestSettings.setAdditionalHeader("Content-Type", "application/x-www-form-urlencoded");
            //requestSettings.setAdditionalHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            //requestSettings.setAdditionalHeader("Referer", "https://app.seoclarity.net/index.jsp");
            //requestSettings.setAdditionalHeader("Accept-Encoding", "gzip,deflate,br");
            //requestSettings.setAdditionalHeader("Accept-Language", "en-US,en;q=0.8");
            requestSettings.setAdditionalHeader("Cookie", "_ga=GA1.2.467644965.1492082877; _at_id.seoclarity.seoclarity.6bab=20c46f90d7f0e0c1.1492083187.0.1492083187..207.207.; intercom-session-yqggvwzy=VlZLN0xpWXNrWEN6UEloU2VlcHNMNnhhWGY1TlR4NjBTb3dtQjZZOU9WeWdORXV2RGFLTjlQcVZ3TmNvOTFKYS0teGdxczI3OHIzSENiSHh2TjIrWW0ydz09--35becb7173804bbb5311fa8ee3241d9b107d4170; JSESSIONID=EBA3A795DA3DF3AD39E103A7C862F074");
            //requestSettings.setAdditionalHeader("Origin", "https://app.seoclarity.net");
            requestSettings.setRequestBody("hash=&email=moyang%40amazon.com&password=bUxH8e40");

            Page redirectPage = webClient.getPage(requestSettings);
            redirectPage.wait(30000L, 0);
            System.out.println(redirectPage.getWebResponse().getContentAsString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            /*
        } catch (InterruptedException e) {
            e.printStackTrace();
            */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
