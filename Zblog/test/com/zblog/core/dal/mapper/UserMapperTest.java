/**
 * 工程名: Zblog
 * 文件名: UserMapperTest.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年11月25日上午11:45:55
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.zblog.core.dal.entity.User;

/**
 * 类名: UserMapperTest <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 上午11:45:55 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactionFactory;
	
	@Before
	public void setUp() throws Exception{
		String resource = "testconfig/SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		if(sqlSessionFactionFactory == null){
			System.out.println("null");
		}else{
			System.out.println("hh");
		}
	}
	
	@Test
	public void testLoadById() {
		SqlSession sqlSession = sqlSessionFactionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.loadById("uHHi9gvg81UXn4PLlLE");
		if(user == null){
			System.out.println("null");
		}else{
			System.out.println(user.getNickName());
		}
		assertEquals(user.getNickName(), "admin");
	}


}

