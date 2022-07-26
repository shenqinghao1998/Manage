package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.domain.SysPayment;

/**
 * 项目Mapper接口
 * 
 * @author SQH
 * @date 2022-07-26
 */
public interface SysContractMapper 
{
    /**
     * 查询项目
     * 
     * @param contractId 项目主键
     * @return 项目
     */
    public SysContract selectSysContractByContractId(Long contractId);

    /**
     * 查询项目列表
     * 
     * @param sysContract 项目
     * @return 项目集合
     */
    public List<SysContract> selectSysContractList(SysContract sysContract);

    /**
     * 新增项目
     * 
     * @param sysContract 项目
     * @return 结果
     */
    public int insertSysContract(SysContract sysContract);

    /**
     * 修改项目
     * 
     * @param sysContract 项目
     * @return 结果
     */
    public int updateSysContract(SysContract sysContract);

    /**
     * 删除项目
     * 
     * @param contractId 项目主键
     * @return 结果
     */
    public int deleteSysContractByContractId(Long contractId);

    /**
     * 批量删除项目
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysContractByContractIds(String[] contractIds);

    /**
     * 批量删除付款
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPaymentByPaymentIds(String[] contractIds);
    
    /**
     * 批量新增付款
     * 
     * @param sysPaymentList 付款列表
     * @return 结果
     */
    public int batchSysPayment(List<SysPayment> sysPaymentList);
    

    /**
     * 通过项目主键删除付款信息
     * 
     * @param contractId 项目ID
     * @return 结果
     */
    public int deleteSysPaymentByPaymentId(Long contractId);
}
