package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysPayment;
import com.ruoyi.system.domain.SysContract;

/**
 * 付款Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
public interface SysPaymentMapper 
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
     * 删除付款
     * 
     * @param contractId 付款主键
     * @return 结果
     */
    public int deleteSysPaymentByContractId(Long contractId);

    /**
     * 批量删除付款
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPaymentByContractIds(String[] contractIds);

    /**
     * 批量删除项目
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysContractByContractIds(String[] contractIds);
    
    /**
     * 批量新增项目
     * 
     * @param sysContractList 项目列表
     * @return 结果
     */
    public int batchSysContract(List<SysContract> sysContractList);
    

    /**
     * 通过付款主键删除项目信息
     * 
     * @param contractId 付款ID
     * @return 结果
     */
    public int deleteSysContractByContractId(Long contractId);
}
