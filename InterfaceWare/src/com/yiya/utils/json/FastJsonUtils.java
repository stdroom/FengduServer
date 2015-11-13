package com.yiya.utils.json;
import com.alibaba.fastjson.JSON;

/**
 * fastjson 是一个性能很好的 Java 语言实现的 JSON 解析器和生成器，来自阿里巴巴的工程师开发。 主要特点：
 * 1.快速FAST(比其它任何基于Java的解析器和生成器更快，包括jackson） 强大（支持普通JDK类包括任意Java Bean
 * 2.Class、Collection、Map、Date或enum） 零依赖（没有依赖其它任何类库除了JDK）
 * 
 */
public class FastJsonUtils {

//	   private static final String DEFAULT_CHARSET_NAME = "UTF-8";

       public static <T> String toJSONString(T object) {
   			return JSON.toJSONString(object);
   	} 
       public static <T> T parseJSONString(String string, Class<T> clz) {
           return JSON.parseObject(string, clz);
       }

    
//       public static void main(String[] args) {
//           Person person1 = new Person();
//           person1.setAddress("address");
//           person1.setAge(11);
//           person1.setName("amao");
//           
//           Person person2 = new Person();
//           person2.setAddress("address");
//           person2.setAge(11);
//           person2.setName("amao");
//           
//           List<Person> lp = new ArrayList<Person>();
//           lp.add(person1);
//           lp.add(person2);
//           System.out.println(serialize(lp));
//       }
}
