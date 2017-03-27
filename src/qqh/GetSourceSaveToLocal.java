package qqh;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 
 * @ClassName: GetSourceSaveToLocal 
 * @Description:  获取网页源代码，并保存成html文件
 * @author qinqh
 * @date 2017年3月27日 上午10:05:47 
 *
 */
public class GetSourceSaveToLocal {

	/**
	 * 
	 * @Title: way_1 
	 * @Description:  获取网页源代码，并保存成html文件方法1
	 * @param sourceUrl
	 * @throws Exception    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void way_1(String sourceUrl ) throws Exception{
		InputStream inputStream;//接收字节输出流
		InputStreamReader inputStreamReader;//将字节输入流转换成字符输入流
		BufferedReader bufferedReader;//为字节输入流加缓冲
		FileOutputStream fileOutputStream;//字节输出流
		OutputStreamWriter outputStreamWriter; //将字节输出流转换成字符输出流
		
		URL url = new URL(sourceUrl);
		inputStream = url.openStream();
		inputStreamReader = new InputStreamReader(inputStream,"utf-8");
		bufferedReader = new BufferedReader(inputStreamReader);
		String s ;
		File dest = new File("src/copyFromWeb.html");
		fileOutputStream = new FileOutputStream(dest);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf-8");
		while ((s = bufferedReader.readLine())!= null){
			outputStreamWriter.write(s);
		}
		 outputStreamWriter.close();
		 fileOutputStream.close();
		 bufferedReader.close();
		 inputStreamReader.close();
		 inputStream.close();
	}
	
	/**
	 * 
	 * @Title: way_2 
	 * @Description:  获取网页源代码，并保存成html文件方法2
	 * @throws Exception    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	public void way_2(String sourceUrl ) throws Exception{
	    File dest = new File("src/wangyi2.html");
	    InputStream is;//接收字节输入流
	    FileOutputStream fos = new FileOutputStream(dest);//字节输出流

	    URL wangyi = new URL(sourceUrl);
	    is = wangyi.openStream();

	    BufferedInputStream bis = new BufferedInputStream(is);//为字节输入流加缓冲
	    BufferedOutputStream bos = new BufferedOutputStream(fos);//为字节输出流加缓冲

	    int length;

	    byte[] bytes = new byte[1024*20];
	    while((length = bis.read(bytes, 0, bytes.length)) != -1){
	        fos.write(bytes, 0, length);
	    }

	    bos.close();
	    fos.close();
	    bis.close();
	    is.close();
	}
	
	
	public static void main(String[] args) {
		GetSourceSaveToLocal gstl = new GetSourceSaveToLocal();
		try {
			gstl.way_1("http://www.baidu.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
