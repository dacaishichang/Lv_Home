package serialport.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
	
    //获取当前日期
	public static String formatDateStr_ss() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	//字符串是否为空
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}
	
	
	//字节数组转换成String，指定长度转换长度
	public static String byteArray2HexString(byte[] arrBytes, int count, boolean blank) {
		String ret = "";
		if (arrBytes == null || arrBytes.length < 1)
			return ret;
		if (count > arrBytes.length)
			count = arrBytes.length;
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < count; i++) {
			ret = Integer.toHexString(arrBytes[i] & 0xFF).toUpperCase();
			if (ret.length() == 1)
				builder.append("0").append(ret);
			else
				builder.append(ret);
			if (blank)
				builder.append(" ");
		}

		return builder.toString();

	}

	public static String DistinguishSource(String str) {
	    String strs[] = str.split(" ");
	    String address = strs[6] + strs[5];
	    if (address.equals("BEC4")) {
	        return "sun";
        } else if (address.equals("2828")){
			return "executor";
        } else if (address.equals("B5A5")){
			if (strs[7].equals("01")) {
				return "tem";
			} else {
				return "wet";
			}
		}else {
	    	return "router";
		}
    }

	public static float HexStringToDataForSun(String str) {
	    String strs[] = str.split(" ");
	    String dataStr = strs[9] + strs[8];
        String guodu = String.valueOf(Integer.valueOf(dataStr, 16));
        String guodu2 = guodu.substring(0,3) + "." +guodu.substring(3);
        return Float.parseFloat(guodu2);
    }

    public static boolean HexStringToDataForHuman(String str) {
	    String strs[] = str.split(" ");
	    String dataStr = strs[8];
        if (strs[8].charAt(1) == '0') {
            return false;
        } else {
            return true;
        }
    }

    public static float HexStringToDataForTem(String str) {
        String strs[] = str.split(" ");
        String dataStr = strs[9] + strs[8];
        String guodu = String.valueOf(Integer.valueOf(dataStr, 16));
        String guodu2 = guodu.substring(0, 2) + "." +guodu.substring(2);
        return Float.parseFloat(guodu2);
    }

    public static float HexStringToDataForWet(String str) {
        String strs[] = str.split(" ");
        String dataStr = strs[20] + strs[19];
        String guodu = String.valueOf(Integer.valueOf(dataStr, 16));
        String guodu2 = guodu.substring(0, 2) + "." +guodu.substring(2);
        return Float.parseFloat(guodu2);
    }

	//将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF, 0xD9}
	public static byte[] HexString2Bytes(String src) {
		// String strTemp = "";
		if (src == null || "".equals(src))
			return null;
		StringBuilder builder = new StringBuilder();
		for (char c : src.trim().toCharArray()) {
			/* 去除中间的空格 */
			if (c != ' ') {
				builder.append(c);
			}
		}
		src = builder.toString();
		byte[] ret = new byte[src.length() / 2];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < src.length() / 2; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	//将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}


	//将字节数组转换成16进制字符串
	public static String byteArrayToHexString(byte[] array) {
		return byteArray2HexString(array,Integer.MAX_VALUE, false);
	}

	//将字节数组转换成long类型
	public static long byteArrayToLong(byte[] bytes) {
		return ((((long) bytes[0] & 0xff) << 24)
				| (((long) bytes[1] & 0xff) << 16)
				| (((long) bytes[2] & 0xff) << 8) | (((long) bytes[3] & 0xff) << 0));
	}
	
	//合并数组  
	public static byte[] concat(byte[] firstArray, byte[] secondArray) {  
	    if (firstArray == null || secondArray == null) {  
	    	if(firstArray != null)
	    		return firstArray;
	    	if(secondArray !=null)
	    		return secondArray;
	        return null;  
	    }  
	    byte[] bytes = new byte[firstArray.length + secondArray.length];  
	    System.arraycopy(firstArray, 0, bytes, 0, firstArray.length);  
	    System.arraycopy(secondArray, 0, bytes, firstArray.length,  
	            secondArray.length);  
	    return bytes;  
	}
}
