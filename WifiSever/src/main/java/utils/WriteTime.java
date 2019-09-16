package utils;

import testDemo.TestWifi;

public class WriteTime implements Runnable{
    public void run() {
        try{
            while(true){
                if(TestWifi.addThreeInfo()!=3){
                    break;
                };
                Thread.sleep(3000);
            }
            System.out.println("连接中断");


        }catch (Exception e){

        }finally {

        }
    }
}
