package com.ruoyi.project.system.tbUser.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.tbUser.mapper.TbUserMapper;
import com.ruoyi.project.system.tbUser.domain.TbUser;
import com.ruoyi.project.system.tbUser.service.ITbUserService;
import com.ruoyi.common.utils.text.Convert;

/**
 * fw 服务层实现
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class TbUserServiceImpl implements ITbUserService 
{
	@Autowired
	private TbUserMapper tbUserMapper;

	/**
     * 查询fw信息
     * 
     * @param id fwID
     * @return fw信息
     */
    @Override
	public TbUser selectTbUserById(Integer id)
	{
	    return tbUserMapper.selectTbUserById(id);
	}
	
	/**
     * 查询fw列表
     * 
     * @param tbUser fw信息
     * @return fw集合
     */
	@Override
	public List<TbUser> selectTbUserList(TbUser tbUser)
	{
	    return tbUserMapper.selectTbUserList(tbUser);
	}
	
    /**
     * 新增fw
     * 
     * @param tbUser fw信息
     * @return 结果
     */
	@Override
	public int insertTbUser(TbUser tbUser)
	{
	    return tbUserMapper.insertTbUser(tbUser);
	}
	
	/**
     * 修改fw
     * 
     * @param tbUser fw信息
     * @return 结果
     */
	@Override
	public int updateTbUser(TbUser tbUser)
	{
	    return tbUserMapper.updateTbUser(tbUser);
	}

	/**
     * 删除fw对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTbUserByIds(String ids)
	{
		return tbUserMapper.deleteTbUserByIds(Convert.toStrArray(ids));
	}
	
}
