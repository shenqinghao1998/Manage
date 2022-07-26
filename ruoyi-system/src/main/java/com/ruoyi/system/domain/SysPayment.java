package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款对象 sys_payment
 * 
 * @author SQH
 * @date 2022-07-26
 */
public class SysPayment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 付款id */
    @Excel(name = "付款id")
    private Long paymentId;

    /** 拟付款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拟付款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date readyDate;

    /** 拟付款金额 */
    @Excel(name = "拟付款金额")
    private BigDecimal readyPayment;

    /** 实际付款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际付款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualDate;

    /** 实际付款金额 */
    @Excel(name = "实际付款金额")
    private BigDecimal actualPayment;

    /** 税率 */
    @Excel(name = "税率")
    private Long tax;

    /** 发票金额 */
    @Excel(name = "发票金额")
    private BigDecimal receiptContext;

    /** 发票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiptDate;

    public void setPaymentId(Long paymentId) 
    {
        this.paymentId = paymentId;
    }

    public Long getPaymentId() 
    {
        return paymentId;
    }
    public void setReadyDate(Date readyDate) 
    {
        this.readyDate = readyDate;
    }

    public Date getReadyDate() 
    {
        return readyDate;
    }
    public void setReadyPayment(BigDecimal readyPayment) 
    {
        this.readyPayment = readyPayment;
    }

    public BigDecimal getReadyPayment() 
    {
        return readyPayment;
    }
    public void setActualDate(Date actualDate) 
    {
        this.actualDate = actualDate;
    }

    public Date getActualDate() 
    {
        return actualDate;
    }
    public void setActualPayment(BigDecimal actualPayment) 
    {
        this.actualPayment = actualPayment;
    }

    public BigDecimal getActualPayment() 
    {
        return actualPayment;
    }
    public void setTax(Long tax) 
    {
        this.tax = tax;
    }

    public Long getTax() 
    {
        return tax;
    }
    public void setReceiptContext(BigDecimal receiptContext) 
    {
        this.receiptContext = receiptContext;
    }

    public BigDecimal getReceiptContext() 
    {
        return receiptContext;
    }
    public void setReceiptDate(Date receiptDate) 
    {
        this.receiptDate = receiptDate;
    }

    public Date getReceiptDate() 
    {
        return receiptDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("paymentId", getPaymentId())
            .append("readyDate", getReadyDate())
            .append("readyPayment", getReadyPayment())
            .append("actualDate", getActualDate())
            .append("actualPayment", getActualPayment())
            .append("tax", getTax())
            .append("receiptContext", getReceiptContext())
            .append("receiptDate", getReceiptDate())
            .toString();
    }
}
