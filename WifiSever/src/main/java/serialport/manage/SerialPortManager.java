package serialport.manage;

import gnu.io.*;
import serialport.exception.ReadDataFromSerialPortFailure;
import serialport.exception.SerialPortInputStreamCloseFailure;
import serialport.utils.MyUtils;
import testDemo.TestDonkey;
import testDemo.TestHome;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;

//import DBAll.DBAll;
//import DBAll.InterAll;


public class SerialPortManager {
	public static float sunValue;
	//public static boolean humanOrNot;
	public static float temValue;
	public static float wetValue;
	

	//打开串口
	public static final SerialPort openPort(String portName, int baudrate)
			throws IOException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
			// 通过端口名识别端口
			CommPortIdentifier portIdentifier = CommPortIdentifier
					.getPortIdentifier(portName);
			// 打开端口，并给端口名字和一个timeout（打开操作的超时时间）
			CommPort commPort = portIdentifier.open(portName, 2000);
			// 判断是不是串口
				SerialPort serialPort = (SerialPort) commPort;
					// 设置一下串口的波特率等参数
					serialPort.setSerialPortParams(baudrate,
							SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);

				return serialPort;
	}

	//关闭串口
	public static void closePort(SerialPort serialPort) {
		if (serialPort != null) {
			serialPort.close();
			serialPort = null;
		}
	}

	//往串口发送数据
	public static void sendToPort(SerialPort serialPort, byte[] order)
			throws IOException {
		OutputStream out = null;
		out = serialPort.getOutputStream();
		out.write(order);
		out.flush();

		if (out != null) {
			out.close();
			out = null;
		}
	}

	//从串口读取数据  
	public static byte[] readMsg(SerialPort serialPort) {  
	    InputStream in = null;  
	    byte[] bytes = {};  
	    try {  
	        in = serialPort.getInputStream();  
	        // 缓冲区大小为一个字节  
	        byte[] readBuffer = new byte[1];  
	        int bytesNum = in.read(readBuffer);  
	        while (bytesNum > 0) {  
	            bytes = MyUtils.concat(bytes, readBuffer);
	            bytesNum = in.read(readBuffer);  
	        }  
	    } catch (IOException e) {  
	        new ReadDataFromSerialPortFailure().printStackTrace();  
	    } finally { 
	        try {  
	            if (in != null) {  
	                in.close();  
	                in = null;  
	            }  
	        } catch (IOException e) {  
	            new SerialPortInputStreamCloseFailure().printStackTrace();
	        }  
	    }
	    String str = MyUtils.byteArray2HexString(bytes, bytes.length, true);
	    String source = MyUtils.DistinguishSource(str);
	    //数据库操作
        if (source.equals("sun")) {
        	sunValue = MyUtils.HexStringToDataForSun(str);
            System.out.println("光照：" + sunValue);
			TestHome.addAndUpdateIllumination(new Float(sunValue));
        } else if (source.equals("executor")){
//            System.out.println("我是执行器！");
        } else if (source.equals("router")){
//            System.out.println("我是路由器！");
		}else {
        	temValue = MyUtils.HexStringToDataForTem(str);
        	wetValue = MyUtils.HexStringToDataForWet(str);
			System.out.println("温度：" + temValue);
			TestHome.addAndUpdateTemperature(new Float(temValue));
//			SendControl(serialPort, "1");
			sendMsg(serialPort,"0");
			System.out.println("湿度：" + wetValue);
			TestHome.addAndUpdateHumidity(new Float(wetValue));
		}
               
//        InterAll interall = new DBAll();
//        interall.InsertAll(sunValue, humanOrNot, temValue);
//
        if(temValue<=25.0&&sunValue>=400.0){
			sendMsg(serialPort,"0");                 //光照温度正常
		}else if(temValue>25.0&&sunValue>=400.0){
			sendMsg(serialPort,"2");                 //温度过高 光照正常 开风扇
		}else if(sunValue<400.0&&temValue<=25.0){
			sendMsg(serialPort,"4");                 //温度正常 光照过低 开灯
		}
		else {
			sendMsg(serialPort,"6");                 //温度过低 光照过低 开灯开风扇
		}
	    return bytes;
	}

	public static void sendMsg(SerialPort serialPort,String com){
		OutputStream out = null;
		String info="";
		String msg = "071800F1282801F"+com;//要发送的命令
		info="02"+msg+checkcode(msg);
		try {
			out = serialPort.getOutputStream();
			out.write(hex2byte(info));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String Xor(String strHex_X,String strHex_Y){     //异或
		//将x、y转成二进制形式
		String anotherBinary=Integer.toBinaryString(Integer.valueOf(strHex_X,16));
		String thisBinary=Integer.toBinaryString(Integer.valueOf(strHex_Y,16));
		String result = "";
		//判断是否为8位二进制，否则左补零
		if(anotherBinary.length() != 8){
			for (int i = anotherBinary.length(); i <8; i++) {
				anotherBinary = "0"+anotherBinary;
			}
		}
		if(thisBinary.length() != 8){
			for (int i = thisBinary.length(); i <8; i++) {
				thisBinary = "0"+thisBinary;
			}
		}

		//异或运算
		for(int i=0;i<anotherBinary.length();i++){
			//如果相同位置数相同，则补0，否则补1
			if(thisBinary.charAt(i)==anotherBinary.charAt(i))
				result+="0";
			else{
				result+="1";
			}
		}
		return Integer.toHexString(Integer.parseInt(result, 2));
	}
	public static String checkcode(String para) {        //生成校验码
		int length = para.length() / 2;
		String[] dateArr = new String[length];
		for (int i = 0; i < length; i++) {
			dateArr[i] = para.substring(i * 2, i * 2 + 2);
		}
		String code = "00";
		for (int i = 0; i < dateArr.length; i++) {
			code = Xor(code, dateArr[i]);
		}
		return code.toUpperCase();                       //转换成大写
	}

	private static byte[] hex2byte(String hex1) {

		String digital = "0123456789ABCDEF";
//		String hex1 = hex.replace(" ", "");
		char[] hex2char = hex1.toCharArray();
		byte[] bytes = new byte[hex1.length() / 2];
		byte temp;
		for (int p = 0; p < bytes.length; p++) {
			temp = (byte) (digital.indexOf(hex2char[2 * p]) * 16);
			temp += digital.indexOf(hex2char[2 * p + 1]);
			bytes[p] = (byte) (temp & 0xff);
		}
		return bytes;
	}

	public static void addListener(SerialPort port,
			SerialPortEventListener listener) throws IOException, TooManyListenersException {
		// 给串口添加监听器
		port.addEventListener(listener);
		// 设置当有数据到达时唤醒监听接收线程
		port.notifyOnDataAvailable(true);
		// 设置当通信中断时唤醒中断线程
		port.notifyOnBreakInterrupt(true);

	}

	//从串口读取RFID数据
	public static byte[] readRfid(SerialPort serialPort) {
		InputStream in = null;
		byte[] bytes = {};
		try {
			in = serialPort.getInputStream();
			// 缓冲区大小为一个字节
			byte[] readBuffer = new byte[1];
			int bytesNum = in.read(readBuffer);
			while (bytesNum > 0) {
				bytes = MyUtils.concat(bytes, readBuffer);
				bytesNum = in.read(readBuffer);
			}
		} catch (IOException e) {
			new ReadDataFromSerialPortFailure().printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
			} catch (IOException e) {
				new SerialPortInputStreamCloseFailure().printStackTrace();
			}
		}
		//将字节数组转换成String，指定长度转换长度
		String str = MyUtils.byteArray2HexString(bytes, bytes.length, true);
		System.out.println(str);
		if(TestDonkey.validateDonkeyByRFID(str.trim())){
			System.out.println("已经存在");
			TestDonkey.addDonkeyHistory(str.trim());
		}else {
			System.out.println("还不存在");
			TestDonkey.addDonkeyByFRID(str.trim());
		}

		return bytes;
	}



}
