package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysAttachmentMapper;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.service.ISysAttachmentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 已上传附件管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-08-19
 */
@Service
public class SysAttachmentServiceImpl implements ISysAttachmentService 
{
    @Autowired
    private SysAttachmentMapper sysAttachmentMapper;

    /**
     * 查询已上传附件管理
     * 
     * @param attachmentId 已上传附件管理主键
     * @return 已上传附件管理
     */
    @Override
    public SysAttachment selectSysAttachmentByAttachmentId(Long attachmentId)
    {
        return sysAttachmentMapper.selectSysAttachmentByAttachmentId(attachmentId);
    }

    /**
     * 查询已上传附件管理列表
     * 
     * @param sysAttachment 已上传附件管理
     * @return 已上传附件管理
     */
    @Override
    public List<SysAttachment> selectSysAttachmentList(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.selectSysAttachmentList(sysAttachment);
    }

    /**
     * 新增已上传附件管理
     * 
     * @param sysAttachment 已上传附件管理
     * @return 结果
     */
    @Override
    public int insertSysAttachment(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.insertSysAttachment(sysAttachment);
    }

    /**
     * 修改已上传附件管理
     * 
     * @param sysAttachment 已上传附件管理
     * @return 结果
     */
    @Override
    public int updateSysAttachment(SysAttachment sysAttachment)
    {
        return sysAttachmentMapper.updateSysAttachment(sysAttachment);
    }

    /**
     * 批量删除已上传附件管理
     * 
     * @param attachmentIds 需要删除的已上传附件管理主键
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentByAttachmentIds(String attachmentIds)
    {
        return sysAttachmentMapper.deleteSysAttachmentByAttachmentIds(Convert.toStrArray(attachmentIds));
    }

    /**
     * 删除已上传附件管理信息
     * 
     * @param attachmentId 已上传附件管理主键
     * @return 结果
     */
    @Override
    public int deleteSysAttachmentByAttachmentId(Long attachmentId)
    {
        return sysAttachmentMapper.deleteSysAttachmentByAttachmentId(attachmentId);
    }
}
