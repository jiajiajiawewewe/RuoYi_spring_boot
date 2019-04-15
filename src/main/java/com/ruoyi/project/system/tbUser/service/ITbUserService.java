package com.ruoyi.project.system.tbUser.service;

import com.ruoyi.project.system.tbUser.domain.TbUser;
import java.util.List;

/**
 * fw 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface ITbUserService 
{
	/**
     * 查询fw信息
     * 
     * @param id fwID
     * @return fw信息
     */
	public TbUser selectTbUserById(Integer id);
	
	/**
     * 查询fw列表
     * 
     * @param tbUser fw信息
     * @return fw集合
     */
	public List<TbUser> selectTbUserList(TbUser tbUser);
	
	/**
     * 新增fw
     * 
     * @param tbUser fw信息
     * @return 结果
     */
	public int insertTbUser(TbUser tbUser);
	
	/**
     * 修改fw
     * 
     * @param tbUser fw信息
     * @return 结果
     */
	public int updateTbUser(TbUser tbUser);
		
	/**
     * 删除fw信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTbUserByIds(String ids);
	
}
