package testDemo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import serialport.manage.SerialPortManager;
import utils.WriteTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.TooManyListenersException;

/**
 * 0500161B00000100 光照
 * 28E15305004B1200 1 温度 2 湿度
 *
 */
public class TestWifi {
    public static int ControlStr=0;//0-15 1 2 4 8

    public static String Illumination="0500161B00000100";
    public static String HumidityAndTemperature="28E15305004B1200";
    public static int HumidityCode = 1;
    public static int TemperatureCode = 1;

    public static int HumidityControl=1;
    public static int TemperatureControl=2;
    public static int IlluminationControl=4;




    public static int addThreeInfo() throws Exception{
        int flag=0;
        /*
        addAndUpdateHumidity(12.1f);
        addAndUpdateIllumination(23.0f);
        addAndUpdateTemperature(38.0f);

        湿度小于35报警1 1 0
        温度高于31报警2 2 0
        光照小于400报警4 4 0
         */
        Double illumination = 0.0;
        Double humidity = 0.0;
        Double temperature = 0.0;

        URL url=new URL("http://192.168.0.1/cgi-bin/node.cgi");
        BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
        String line=null;
        if((line=reader.readLine())==null){
            System.out.println("出错了！");
        }
        reader.close();
        JSONArray json = JSONArray.fromObject(line);
        for(int i=0;i<json.size();i++){
            JSONObject job = json.getJSONObject(i);
            if(job.get("macAddr").toString().equals(Illumination)){//光照

                JSONArray tmpArray = job.getJSONArray("funcList");
                illumination = Double.parseDouble(tmpArray.getJSONObject(0).getString("data"));
                TestHome.addAndUpdateIllumination(illumination.floatValue());
                ++flag;
                System.out.println(illumination+":");
            }else if(job.get("macAddr").toString().equals(HumidityAndTemperature)){//温度和湿度

                JSONArray tmpArray = job.getJSONArray("funcList");
                //湿度解析
                humidity = Double.parseDouble(tmpArray.getJSONObject(1).getString("data"));//湿度
                TestHome.addAndUpdateHumidity(humidity.floatValue());
                ++flag;
                System.out.println(humidity);

                //温度解析
                temperature = tmpArray.getJSONObject(0).getDouble("data");//温度
                TestHome.addAndUpdateTemperature(temperature.floatValue());
                ++flag;
                System.out.println(temperature);

            }
        }
        TestHttp.sendControl(check(temperature,illumination,humidity));


        return flag;
    }


    /**
     * 湿度小于35报警1 1 0
     * 温度高于31报警2 2 0
     * 光照小于400报警4 4 0
     * @param temperature
     * @param illumination
     * @param humidity
     * @return
     */
    public static int check(double temperature,double illumination ,double humidity){
        ControlStr=0;
        HumidityControl = humidity<35.0?1:0;//湿度
        TemperatureControl = temperature>21.0?2:0;//温度
        IlluminationControl = illumination<400.0?4:0;//光照
        ControlStr=HumidityControl+TemperatureControl+IlluminationControl;
        return ControlStr;
    }

}
