package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysPayment;

/**
 * 付款Service接口
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public interface ISysPaymentService 
{
    /**
     * 查询付款
     * 
     * @param contractId 付款主键
     * @return 付款
     */
    public SysPayment selectSysPaymentByContractId(Long contractId);

    /**
     * 查询付款列表
     * 
     * @param sysPayment 付款
     * @return 付款集合
     */
    public List<SysPayment> selectSysPaymentList(SysPayment sysPayment);

    /**
     * 新增付款
     * 
     * @param sysPayment 付款
     * @return 结果
     */
    public int insertSysPayment(SysPayment sysPayment);

    /**
     * 修改付款
     * 
     * @param sysPayment 付款
     * @return 结果
     */
    public int updateSysPayment(SysPayment sysPayment);

    /**
     * 批量删除付款
     * 
     * @param contractIds 需要删除的付款主键集合
     * @return 结果
     */
    public int deleteSysPaymentByContractIds(String contractIds);

    /**
     * 删除付款信息
     * 
     * @param contractId 付款主键
     * @return 结果
     */
    public int deleteSysPaymentByContractId(Long contractId);
}
