package org.admin.utils;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class UUIDUtil {
	
	private static final String numberChars = "0123456789";
	private static final String chars36 = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	private static final String __randChars = "0123456789abcdefghigklmnopqrstuvtxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";

	private final static String chars64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789ffabcdefghijklmnopqrstuvwxyz";

    private static final String HMAC_SHA1_NAME = "HmacSHA1";    
    public static final String ENCODING_UTF8 = "UTF-8";
    
	private final static Random __random = new Random(System.currentTimeMillis());
	
	public final static String generateCharUUID(Object o) {
		long id1 = System.currentTimeMillis() & 0xFFFFFFFFL;
		long id2 = System.identityHashCode(o);
		long id3 = randomLong(-0x80000000L, 0x80000000L) & 0xFFFFFFFFL;
		id1 <<= 16;
		id1 += (id2 & 0xFFFF0000L) >> 16;
		id3 += (id2 & 0x0000FFFFL) << 32;
		String out = __convert(id1, 6, chars64) + __convert(id3, 6, chars64);
		out = out.replaceAll(" ", "o");
		return out;
	}
	
	
	public final static String generateNumberUUID(Object o) {
		long id1 = System.currentTimeMillis() & 0xFFFFFFFFL;
		long id2 = System.identityHashCode(o);
		long id3 = randomLong(-0x80000000L, 0x80000000L) & 0xFFFFFFFFL;
		id1 <<= 16;
		id1 += (id2 & 0xFFFF0000L) >> 16;
		id3 += (id2 & 0x0000FFFFL) << 32;
		return "" + id1 + id3;
	}
	
	public final static String generate() {
		long id1 = System.currentTimeMillis() & 0x3FFFFFFFL;
		long id3 = randomLong(-0x80000000L, 0x80000000L) & 0x3FFFFFFFL;
		String out = __convert(id1, 6, chars64) + __convert(id3, 6, chars64);
		out = out.replaceAll(" ", "o");
		return out;
	}
	
	public final static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	private static String __convert(long x, int n, String d) {
		if (x == 0) {
			return "0";
		}
		String r = "";
		int m = 1 << n;
		m--;
		while (x != 0) {
			r = d.charAt((int) (x & m)) + r;
			x = x >>> n;
		}
		return r;
	}
	
	public static String randomString(int length, boolean isOnlyNum) {
		int size = isOnlyNum ? 10 : 62;
		StringBuffer hash = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			hash.append(__randChars.charAt(__random.nextInt(size)));
		}
		return hash.toString();
	}
	
	/**
	 * Generates pseudo-random long from specific range. Generated number is
	 * great or equals to min parameter value and less then max parameter value.
	 * 
	 * @param min lower (inclusive) boundary
	 * @param max higher (exclusive) boundary
	 * 
	 * @return pseudo-random value
	 */
	public static long randomLong(long min, long max) {
		return min + (long) (Math.random() * (max - min));
	}
	
	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public final static String getCheckcode(int length){
		StringBuffer codeStr = new  StringBuffer();
		Random random = new Random();
		int index = 0;
		int charsLen = chars36.length();
		 for(int i=0; i<length; i++){
			 index = Math.abs(random.nextInt()%charsLen);
			 codeStr.insert(0, chars36.charAt(index));
		 }
		 return codeStr.toString();
	}
	
	public final static String getMsgcode(int length){
		StringBuffer codeStr = new  StringBuffer();
		Random random = new Random();
		int index = 0;
		int charsLen = numberChars.length();
		 for(int i=0; i<length; i++){
			 index = Math.abs(random.nextInt()%charsLen);
			 codeStr.insert(0, numberChars.charAt(index));
		 }
		 return codeStr.toString();
	}

	/**
	 * Generates pseudo-random integer from specific range. Generated number is
	 * great or equals to min parameter value and less then max parameter value.
	 * 
	 * @param min lower (inclusive) boundary
	 * @param max higher (exclusive) boundary
	 * 
	 * @return pseudo-random value
	 */
	public static int randomInt(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}
	
    public static int FNVHash1(String data){   
        final int p = 16777619;   
        int hash = (int)2166136261L;
        for(int i=0;i<data.length();i++)   
            hash = (hash ^ data.charAt(i)) * p;
        hash += hash << 13;   
        hash ^= hash >> 7;   
        hash += hash << 3;   
        hash ^= hash >> 17;   
        hash += hash << 5;
        return hash;   
    }
    
    public static String hashNum(String data, int range){
    	CRC32 crc32 = new CRC32();
    	crc32.update(data.getBytes());
    	long hash = crc32.getValue();
    	hash = hash % range; 
		return String.valueOf(hash);
    }
    
    public static String hashTableId(String data, int range){
    	CRC32 crc32 = new CRC32();
    	crc32.update(data.getBytes());
    	long hash = crc32.getValue();
    	hash = hash % range + 1; 
		return String.valueOf(hash);
    }
    
    public static String hashTableId(int data, int range){
    	int hash = (data % range + 1);
    	return String.valueOf(hash);
    }
    
    public static String getHmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {           
        byte[] keyBytes = encryptKey.getBytes(ENCODING_UTF8);
        byte[] textBytes = encryptText.getBytes(ENCODING_UTF8);
        SecretKey secretKey = new SecretKeySpec(keyBytes, HMAC_SHA1_NAME);
        Mac mac = Mac.getInstance(HMAC_SHA1_NAME);   
        mac.init(secretKey);
        return new String(Base64.encodeBase64String(mac.doFinal(textBytes)));  
    }  
    
    public static String makeSessionId() {
    	return UUIDUtil.md5(UUIDUtil.generateCharUUID("sessionid"))
				+ UUIDUtil.randomString(8, false).toLowerCase();
    }
    
	public static boolean checkUsername(String username){
		Pattern pattern = Pattern.compile("^(1[0-9]{10})$");
		Matcher matcher = pattern.matcher(username);
		return matcher.matches();
	}
	
	public static String getCmdid(String module, String action){
		return UUIDUtil.md5(module+"_"+action);
	}
}
