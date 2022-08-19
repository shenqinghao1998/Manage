package com.ruoyi.system.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 已上传附件管理Controller
 * 
 * @author ruoyi
 * @date 2022-08-19
 */
@Controller
@RequestMapping("/system/attachment")
public class SysAttachmentController extends BaseController
{
    private String prefix = "system/attachment";

    @Autowired
    private ISysAttachmentService sysAttachmentService;

    @RequiresPermissions("system:attachment:view")
    @GetMapping()
    public String attachment()
    {
        return prefix + "/attachment";
    }

    /**
     * 查询已上传附件管理列表
     */
    @RequiresPermissions("system:attachment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysAttachment sysAttachment)
    {
        startPage();
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        return getDataTable(list);
    }

    /**
     * 导出已上传附件管理列表
     */
    @RequiresPermissions("system:attachment:export")
    @Log(title = "已上传附件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysAttachment sysAttachment)
    {
        List<SysAttachment> list = sysAttachmentService.selectSysAttachmentList(sysAttachment);
        ExcelUtil<SysAttachment> util = new ExcelUtil<SysAttachment>(SysAttachment.class);
        return util.exportExcel(list, "已上传附件管理数据");
    }

    /**
     * 新增已上传附件管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存已上传附件管理
     */
    @RequiresPermissions("system:attachment:add")
    @Log(title = "已上传附件管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.insertSysAttachment(sysAttachment));
    }

    /**
     * 修改已上传附件管理
     */
    @RequiresPermissions("system:attachment:edit")
    @GetMapping("/edit/{attachmentId}")
    public String edit(@PathVariable("attachmentId") Long attachmentId, ModelMap mmap)
    {
        SysAttachment sysAttachment = sysAttachmentService.selectSysAttachmentByAttachmentId(attachmentId);
        mmap.put("sysAttachment", sysAttachment);
        return prefix + "/edit";
    }

    /**
     * 修改保存已上传附件管理
     */
    @RequiresPermissions("system:attachment:edit")
    @Log(title = "已上传附件管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysAttachment sysAttachment)
    {
        return toAjax(sysAttachmentService.updateSysAttachment(sysAttachment));
    }

    /**
     * 删除已上传附件管理
     */
    @RequiresPermissions("system:attachment:remove")
    @Log(title = "已上传附件管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysAttachmentService.deleteSysAttachmentByAttachmentIds(ids));
    }
}
