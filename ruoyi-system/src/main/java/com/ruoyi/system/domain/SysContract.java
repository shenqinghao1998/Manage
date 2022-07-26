package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目对象 sys_contract
 * 
 * @author SQH
 * @date 2022-07-26
 */
public class SysContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long contractId;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private Long contractType;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String contractName;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private Long contractNumber;

    /** 项目签约方 */
    @Excel(name = "项目签约方")
    private String contractCus;

    /** 项目经办人 */
    @Excel(name = "项目经办人")
    private String contractSign;

    /** 验收日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "验收日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmDate;

    /** 质保期 */
    @Excel(name = "质保期")
    private Long exceedMonth;

    /** 出保日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出保日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date equipmentExceeded;

    /** 合同金额 */
    @Excel(name = "合同金额")
    private BigDecimal contractContext;

    /** 隶属部门 */
    private Long deptId;

    /** 创建人 */
    private Long userId;

    /** 付款信息 */
    private List<SysPayment> sysPaymentList;

    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractType(Long contractType) 
    {
        this.contractType = contractType;
    }

    public Long getContractType() 
    {
        return contractType;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setContractNumber(Long contractNumber) 
    {
        this.contractNumber = contractNumber;
    }

    public Long getContractNumber() 
    {
        return contractNumber;
    }
    public void setContractCus(String contractCus) 
    {
        this.contractCus = contractCus;
    }

    public String getContractCus() 
    {
        return contractCus;
    }
    public void setContractSign(String contractSign) 
    {
        this.contractSign = contractSign;
    }

    public String getContractSign() 
    {
        return contractSign;
    }
    public void setConfirmDate(Date confirmDate) 
    {
        this.confirmDate = confirmDate;
    }

    public Date getConfirmDate() 
    {
        return confirmDate;
    }
    public void setExceedMonth(Long exceedMonth) 
    {
        this.exceedMonth = exceedMonth;
    }

    public Long getExceedMonth() 
    {
        return exceedMonth;
    }
    public void setEquipmentExceeded(Date equipmentExceeded) 
    {
        this.equipmentExceeded = equipmentExceeded;
    }

    public Date getEquipmentExceeded() 
    {
        return equipmentExceeded;
    }
    public void setContractContext(BigDecimal contractContext) 
    {
        this.contractContext = contractContext;
    }

    public BigDecimal getContractContext() 
    {
        return contractContext;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public List<SysPayment> getSysPaymentList()
    {
        return sysPaymentList;
    }

    public void setSysPaymentList(List<SysPayment> sysPaymentList)
    {
        this.sysPaymentList = sysPaymentList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("contractId", getContractId())
            .append("contractType", getContractType())
            .append("contractName", getContractName())
            .append("contractNumber", getContractNumber())
            .append("contractCus", getContractCus())
            .append("contractSign", getContractSign())
            .append("confirmDate", getConfirmDate())
            .append("exceedMonth", getExceedMonth())
            .append("equipmentExceeded", getEquipmentExceeded())
            .append("contractContext", getContractContext())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .append("sysPaymentList", getSysPaymentList())
            .toString();
    }
}
