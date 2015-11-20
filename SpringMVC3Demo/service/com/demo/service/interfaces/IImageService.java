/**
 * 工程名: SpringMVC3Demo
 * 文件名: IImageService.java
 * 包名: com.demo.service.interfaces
 * 日期: 2015年11月20日下午2:00:07
 * QQ: 378640336
 *
*/

package com.demo.service.interfaces;

import com.demo.dao.interfaces.IAccountDao;
import com.demo.dao.interfaces.IImageDao;
import com.demo.model.models.Account;
import com.demo.model.models.Image;
import com.infrastructure.project.base.service.interfaces.IEnableEntityService;
import com.infrastructure.project.common.utilities.PageList;

/**
 * 类名: IImageService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月20日 下午2:00:07 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface IImageService extends IEnableEntityService<Integer, Image, IImageDao>{

	PageList<Image> listPage(String name, int pageNo, int pageSize);
}

