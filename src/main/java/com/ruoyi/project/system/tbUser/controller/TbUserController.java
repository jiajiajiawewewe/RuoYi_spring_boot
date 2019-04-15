package com.ruoyi.project.system.tbUser.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.tbUser.domain.TbUser;
import com.ruoyi.project.system.tbUser.service.ITbUserService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * fw信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/tbUser")
public class TbUserController extends BaseController
{
    private String prefix = "system/tbUser";
	
	@Autowired
	private ITbUserService tbUserService;
	
	@RequiresPermissions("system:tbUser:view")
	@GetMapping()
	public String tbUser()
	{
	    return prefix + "/tbUser";
	}
	
	/**
	 * 查询fw列表
	 */
	@RequiresPermissions("system:tbUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TbUser tbUser)
	{
		startPage();
        List<TbUser> list = tbUserService.selectTbUserList(tbUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出fw列表
	 */
	@RequiresPermissions("system:tbUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbUser tbUser)
    {
    	List<TbUser> list = tbUserService.selectTbUserList(tbUser);
        ExcelUtil<TbUser> util = new ExcelUtil<TbUser>(TbUser.class);
        return util.exportExcel(list, "tbUser");
    }
	
	/**
	 * 新增fw
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存fw
	 */
	@RequiresPermissions("system:tbUser:add")
	@Log(title = "fw", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TbUser tbUser)
	{		
		return toAjax(tbUserService.insertTbUser(tbUser));
	}

	/**
	 * 修改fw
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		TbUser tbUser = tbUserService.selectTbUserById(id);
		mmap.put("tbUser", tbUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存fw
	 */
	@RequiresPermissions("system:tbUser:edit")
	@Log(title = "fw", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TbUser tbUser)
	{		
		return toAjax(tbUserService.updateTbUser(tbUser));
	}
	
	/**
	 * 删除fw
	 */
	@RequiresPermissions("system:tbUser:remove")
	@Log(title = "fw", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tbUserService.deleteTbUserByIds(ids));
	}
	
}
