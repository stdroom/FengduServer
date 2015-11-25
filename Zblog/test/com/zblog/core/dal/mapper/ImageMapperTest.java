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

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.zblog.core.dal.entity.Image;
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
public class ImageMapperTest extends TestCase {

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
		ImageMapper userMapper = sqlSession.getMapper(ImageMapper.class);
		Image user = userMapper.loadByIntId(102);
		System.out.println(user.getTitle()
				+"\n"+user.getContextHtml()
				+"\n"+user.getThumbNail()
				+"\n"+user.getPageNum()
				);
		assertEquals(user.getCata_id(), new Integer(1106));
		
	}
//
	public void testListPageModelOfT() {
		SqlSession sqlSession = sqlSessionFactionFactory.openSession();
		ImageMapper userMapper = sqlSession.getMapper(ImageMapper.class);
		PageModel<Image> model = new PageModel<>(1,5);
		model.setContent(userMapper.list(model));
		ArrayList<Image> list = (ArrayList<Image>)model.getContent();
		assertEquals(list.size(), 5);
		for(int i = 0 ;i < list.size();i++){
			
			System.out.println(list.get(i).getTitle()
					+"\n"+list.get(i).getContextHtml()
					+"\n"+list.get(i).getThumbNail()
					+"\n"+list.get(i).getPageNum()
					);
		}
		
	}

	public void testCount() {
		SqlSession sqlSession = sqlSessionFactionFactory.openSession();
		ImageMapper userMapper = sqlSession.getMapper(ImageMapper.class);
		assertEquals(userMapper.count(),493);
	}

}

