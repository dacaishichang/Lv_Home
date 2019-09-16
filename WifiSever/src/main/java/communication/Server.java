package communication;

import gnu.io.*;
import serialport.manage.SerialPortManager;
import testDemo.TestWifi;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.TooManyListenersException;

//import DBAll.DBAll;
//import DBAll.InterAll;
//import Substance.Temperill;

public class Server {
	public ServerSocket serverSocket = null;
	public final int port = 8887;
	private static SerialPort serialPort1;  //串口
	private static SerialPort serialPort2;  //串口

//	private static class SerialListener1 implements SerialPortEventListener {
		/**
		 * 处理监控到的串口事件
		 */

//		public void serialEvent(SerialPortEvent serialPortEvent) {
//			switch (serialPortEvent.getEventType()) {
//				case SerialPortEvent.BI: // 6 通讯中断
//					break;
//				case SerialPortEvent.OE: // 5 溢位（溢出）错误
//					System.out.println("溢出");
//				case SerialPortEvent.FE: // 4 帧错误
//					System.out.println("帧结构不完整");
//				case SerialPortEvent.PE: // 3 奇偶校验错误
//					System.out.println("奇偶校验");
//				case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
//					break;
//				case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据
//					byte[] data = null;
//					try {
//						if (serialPort1 == null) {
//							System.out.println("串口6对象为空！监听失败！");
//						} else {
//							// 读取串口RFID数据
//							data = SerialPortManager.readRfid(serialPort1);
//						}
//					} catch (Exception e) {
//						System.out.println("error1");
//						// 发生读取错误时显示错误信息后退出系统
//						System.exit(0);
//					}
//					break;
//			}
//		}



//	}


//	private static class SerialListener2 implements SerialPortEventListener {
//		/**
//		 * 处理监控到的串口事件
//		 */
//		public void serialEvent(SerialPortEvent serialPortEvent) {
//			switch (serialPortEvent.getEventType()) {
//				case SerialPortEvent.BI: // 6 通讯中断
//					break;
//				case SerialPortEvent.OE: // 5 溢位（溢出）错误
//					System.out.println("溢出");
//				case SerialPortEvent.FE: // 4 帧错误
//					System.out.println("帧结构不完整");
//				case SerialPortEvent.PE: // 3 奇偶校验错误
//					System.out.println("奇偶校验");
//				case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2 输出缓冲区已清空
//					break;
//				case SerialPortEvent.DATA_AVAILABLE: // 1 串口存在可用数据
//					byte[] data = null;
//					try {
//						if (serialPort2 == null) {
//							System.out.println("串口6对象为空！监听失败！");
//						} else {
//							// 读取串口数据
//							data = SerialPortManager.readMsg(serialPort2);
//						}
//					} catch (Exception e) {
//						System.out.println("error2");
//						e.printStackTrace();
//						// 发生读取错误时显示错误信息后退出系统
//						System.exit(0);
//					}
//					break;
//			}
//		}
//	}

	public static void main(String[] args) throws IOException, TooManyListenersException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {

		Thread thread1 = new Thread() {
			@Override
			public void run() {
				while(true){
					try {
						TestWifi.addThreeInfo();
						Thread.sleep(3000);//每隔三秒读取一次ZigBee信息
						System.out.println("添加了");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread1.start();
	}
}
