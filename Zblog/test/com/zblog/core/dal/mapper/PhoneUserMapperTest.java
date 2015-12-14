/**
 * 工程名: Zblog
 * 文件名: ImageMapperTest.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年11月25日下午3:18:39
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.zblog.core.dal.entity.Image;
import com.zblog.core.dal.entity.PhoneUser;
import com.zblog.core.dal.entity.User;
import com.zblog.core.plugin.PageModel;

import junit.framework.TestCase;

/**
 * 类名: ImageMapperTest <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 下午3:18:39 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class PhoneUserMapperTest extends TestCase {

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
	
	public void testLoadById() {
		SqlSession sqlSession = sqlSessionFactionFactory.openSession();
		PhoneUserMapper userMapper = sqlSession.getMapper(PhoneUserMapper.class);
		int i = 1;
		PhoneUser phoneUser = new PhoneUser();
		phoneUser.setIid(3);
		phoneUser.setId("2");
		phoneUser.setAppid(233);
		phoneUser.setAppversion(233);
		phoneUser.setDate(new Date());
		phoneUser.setImei("imei");
		phoneUser.setOsversion("osversion");
		phoneUser.setLang("as");
		phoneUser.setPhone_type("android");
		phoneUser.setTimestamp("asd");
		phoneUser.setClient_type("ad");
		phoneUser.setHttpcount(23);
		userMapper.insert(phoneUser);
		PhoneUser user = userMapper.loadByPhoneUser(2);
		System.out.println(user.getClient_type()
				+"\n"+user.getImei()
				+"\n"+user.getPhone_type()
				+"\n"+user.getAppid()
				);
		assertEquals(user.getAppid(), new Integer(233));
	}
//
//	public void testListPageModelOfT() {
//		SqlSession sqlSession = sqlSessionFactionFactory.openSession();
//		ImageMapper userMapper = sqlSession.getMapper(ImageMapper.class);
//		PageModel<Image> model = new PageModel<>(1,10);
//		model.insertQuery("appid", 102601);
//		model.insertQuery("columnid", 1);
//		model.setContent(userMapper.list(model));
//		model.setContent(userMapper.getImageListByColumn(model));
//		ArrayList<Image> list = (ArrayList<Image>)model.getContent();
//		assertEquals(list.size(), 91);
//		for(int i = 0 ;i < list.size();i++){
//			
//			System.out.println(list.get(i).getCata_id()+list.get(i).getTitle()
//					);
//		}
//		
//	}
}

