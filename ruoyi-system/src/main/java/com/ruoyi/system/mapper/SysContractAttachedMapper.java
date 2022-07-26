package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysContractAttached;
import com.ruoyi.system.domain.SysContract;

/**
 * 附件管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-18
 */
public interface SysContractAttachedMapper 
{
    /**
     * 查询附件管理
     * 
     * @param contractId 附件管理主键
     * @return 附件管理
     */
    public SysContractAttached selectSysContractAttachedByContractId(Long contractId);

    /**
     * 查询附件管理列表
     * 
     * @param sysContractAttached 附件管理
     * @return 附件管理集合
     */
    public List<SysContractAttached> selectSysContractAttachedList(SysContractAttached sysContractAttached);

    /**
     * 新增附件管理
     * 
     * @param sysContractAttached 附件管理
     * @return 结果
     */
    public int insertSysContractAttached(SysContractAttached sysContractAttached);

    /**
     * 修改附件管理
     * 
     * @param sysContractAttached 附件管理
     * @return 结果
     */
    public int updateSysContractAttached(SysContractAttached sysContractAttached);

    /**
     * 删除附件管理
     * 
     * @param contractId 附件管理主键
     * @return 结果
     */
    public int deleteSysContractAttachedByContractId(Long contractId);

    /**
     * 批量删除附件管理
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysContractAttachedByContractIds(String[] contractIds);

    /**
     * 批量删除项目详情
     * 
     * @param contractIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysContractByContractIds(String[] contractIds);
    
    /**
     * 批量新增项目详情
     * 
     * @param sysContractList 项目详情列表
     * @return 结果
     */
    public int batchSysContract(List<SysContract> sysContractList);
    

    /**
     * 通过附件管理主键删除项目详情信息
     * 
     * @param contractId 附件管理ID
     * @return 结果
     */
    public int deleteSysContractByContractId(Long contractId);
}
