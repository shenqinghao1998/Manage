package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysContractAttached;

/**
 * 附件管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-18
 */
public interface ISysContractAttachedService 
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
     * 批量删除附件管理
     * 
     * @param contractIds 需要删除的附件管理主键集合
     * @return 结果
     */
    public int deleteSysContractAttachedByContractIds(String contractIds);

    /**
     * 删除附件管理信息
     * 
     * @param contractId 附件管理主键
     * @return 结果
     */
    public int deleteSysContractAttachedByContractId(Long contractId);
}
