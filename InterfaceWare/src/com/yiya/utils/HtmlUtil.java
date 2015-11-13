package com.yiya.utils;
import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.OutputStream;  
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


import com.yiya.utils.json.FastJsonUtils;

/**
 * <br>
 * <b>功能：</b>详细的功能描述<br>
 * <b>作者：</b>罗泽军<br>
 * <b>日期：</b> Dec 14, 2011 <br>
 * <b>更新者：</b><br>
 * <b>日期：</b> <br>
 * <b>更新内容：</b><br>
 */
public class HtmlUtil {
	private static final String ENCODING = "UTF-8";  
	/**
	 * 
	 * <br>
	 * <b>功能：</b>输出json格式<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 14, 2011 <br>
	 * @param response
	 * @param jsonStr
	 * @throws Exception
	 */
	public static void writerJson(HttpServletResponse response,String jsonStr) {
			writer(response,jsonStr);
	}
	
	public static void writerJson(HttpServletResponse response,Object object){
			try {
				response.setContentType("application/json");
//				writer(response,JSONUtil.toJSONString(object));
//				writer(response,FastJsonUtils.toJSONString(object));
				gzip(response,FastJsonUtils.toJSONString(object));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
private static void gzip(HttpServletResponse response,String object) {
	if(object==null) object="";
     try {  
    	 byte[] data = object.getBytes(ENCODING);  
         ByteArrayOutputStream baos = new ByteArrayOutputStream();  
         // 压缩  
         GZIPOutputStream gos = new GZIPOutputStream(baos);  
         gos.write(data, 0, data.length);  
         gos.finish();  
         byte[] output = baos.toByteArray();  
         baos.flush();  
         baos.close();  
         
         // 设置Content-Encoding，这是关键点！  
         response.setHeader("Content-Encoding", "gzip");  
         // 设置字符集  
         response.setCharacterEncoding(ENCODING);  
         // 设定输出流中内容长度  
         response.setContentLength(output.length);  

         OutputStream out = response.getOutputStream();  
         out.write(output);  
         out.flush();  
         out.close();  
     } catch (Exception e) {  
         e.printStackTrace();  
     }
}
	/**
	 * 
	 * <br>
	 * <b>功能：</b>输出HTML代码<br>
	 * <b>作者：</b>罗泽军<br>
	 * <b>日期：</b> Dec 14, 2011 <br>
	 * @param response
	 * @param htmlStr
	 * @throws Exception
	 */
	public static void writerHtml(HttpServletResponse response,String htmlStr) {
		writer(response,htmlStr);
	}
	
	private static void writer(HttpServletResponse response,String str){
		try {
			StringBuffer result = new StringBuffer();
			//设置页面不缓存
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
