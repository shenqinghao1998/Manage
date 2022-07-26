package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件管理对象 sys_contract_attached
 * 
 * @author SQH
 * @date 2022-07-18
 */
public class SysContractAttached extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目ID */
    @Excel(name = "项目ID")
    private Long contractId;

    /** 附件名称 */
    @Excel(name = "附件名称")
    private String attachedName;

    /** 附件内容 */
    @Excel(name = "附件内容")
    private String attachedFiles;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setAttachedName(String attachedName) 
    {
        this.attachedName = attachedName;
    }

    public String getAttachedName() 
    {
        return attachedName;
    }
    public void setAttachedFiles(String attachedFiles) 
    {
        this.attachedFiles = attachedFiles;
    }

    public String getAttachedFiles() 
    {
        return attachedFiles;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("attachedName", getAttachedName())
            .append("attachedFiles", getAttachedFiles())
            .toString();
    }
}
