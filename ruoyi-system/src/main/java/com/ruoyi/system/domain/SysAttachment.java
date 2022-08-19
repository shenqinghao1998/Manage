package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件对象 sys_attachment
 * 
 * @author ruoyi
 * @date 2022-08-19
 */
public class SysAttachment extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    private Long attachmentId;

    private String fileName;

    public SysAttachment(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    /** 文件路径 */

    private String filePath;

    public void setAttachmentId(Long attachmentId) 
    {
        this.attachmentId = attachmentId;
    }

    public Long getAttachmentId() 
    {
        return attachmentId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attachmentId", getAttachmentId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .toString();
    }
}
