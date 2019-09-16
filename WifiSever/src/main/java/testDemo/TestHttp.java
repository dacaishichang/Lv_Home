package testDemo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class TestHttp {

    public static int controlStr = 2;

    public static boolean sendControl(int control){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;
        int flag=0;
        try {
            URL url = new URL("http://192.168.87.130/cgi-bin/send_node.cgi/?type=11&id=3&data="+control);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.connect();
            if(connection.getResponseCode() == 200){
                System.out.println("改变成功！");
                flag=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag==1;
    }
}
