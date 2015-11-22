/**
 * 工程名: SpringMVC3Demo
 * 文件名: TestMain.java
 * 包名: utils
 * 日期: 2015年11月21日上午11:01:39
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;

/**
 * 类名: TestMain <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月21日 上午11:01:39 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class TestMain {

	public static void main(String[] args) {

		String s = "菠萝社模特柳侑绮Sevenbaby浴室个性艺术摄影";
		String str= "";
		try {
			str = new String(s.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			
		}
		System.out.println(str);
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("status", "1");
		map.put("key", str);
		System.out.println(StringCompress.uncompress(StringCompress.compress(JSON.toJSONString(map))));

	}

}

