/**
 * 工程名: Zblog
 * 文件名: ImageMapper.java
 * 包名: com.zblog.core.dal.mapper
 * 日期: 2015年11月25日下午2:22:32
 * QQ: 378640336
 *
*/

package com.zblog.core.dal.mapper;

import java.util.ArrayList;

import com.zblog.core.dal.entity.Image;
import com.zblog.core.plugin.PageModel;

/**
 * 类名: ImageMapper <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月25日 下午2:22:32 <br/>
 *
 * @author   leixun
 * @version  	 
 */

public interface ImageMapper extends BaseMapper {

	public Image loadByIntId(Integer id);
	
	public ArrayList<Image> getImageListByColumn(PageModel<Image> model,int cataId);
}

