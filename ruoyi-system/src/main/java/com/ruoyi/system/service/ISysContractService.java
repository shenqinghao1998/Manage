package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.domain.SysPayment;

/**
 * 项目Service接口
 * 
 * @author SQH
 * @date 2022-07-26
 */
public interface ISysContractService 
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
     * 查询子表详情
     * @param sysContract
     * @return
     */
    public List<SysPayment> selectSysDetailContractList(SysContract sysContract);
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
     * 批量删除项目
     * 
     * @param contractIds 需要删除的项目主键集合
     * @return 结果
     */
    public int deleteSysContractByContractIds(String contractIds);

    /**
     * 删除项目信息
     * 
     * @param contractId 项目主键
     * @return 结果
     */
    public int deleteSysContractByContractId(Long contractId);
}
