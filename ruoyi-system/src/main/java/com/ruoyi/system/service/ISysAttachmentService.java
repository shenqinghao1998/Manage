package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysAttachment;

/**
 * 已上传附件管理Service接口
 * 
 * @author ruoyi
 * @date 2022-08-19
 */
public interface ISysAttachmentService 
{
    /**
     * 查询已上传附件管理
     * 
     * @param attachmentId 已上传附件管理主键
     * @return 已上传附件管理
     */
    public SysAttachment selectSysAttachmentByAttachmentId(Long attachmentId);

    /**
     * 查询已上传附件管理列表
     * 
     * @param sysAttachment 已上传附件管理
     * @return 已上传附件管理集合
     */
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment);

    /**
     * 新增已上传附件管理
     * 
     * @param sysAttachment 已上传附件管理
     * @return 结果
     */
    public int insertSysAttachment(SysAttachment sysAttachment);

    /**
     * 修改已上传附件管理
     * 
     * @param sysAttachment 已上传附件管理
     * @return 结果
     */
    public int updateSysAttachment(SysAttachment sysAttachment);

    /**
     * 批量删除已上传附件管理
     * 
     * @param attachmentIds 需要删除的已上传附件管理主键集合
     * @return 结果
     */
    public int deleteSysAttachmentByAttachmentIds(String attachmentIds);

    /**
     * 删除已上传附件管理信息
     * 
     * @param attachmentId 已上传附件管理主键
     * @return 结果
     */
    public int deleteSysAttachmentByAttachmentId(Long attachmentId);
}
