package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.mapper.SysContractAttachedMapper;
import com.ruoyi.system.domain.SysContractAttached;
import com.ruoyi.system.service.ISysContractAttachedService;
import com.ruoyi.common.core.text.Convert;

/**
 * 附件管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-18
 */
@Service
public class SysContractAttachedServiceImpl implements ISysContractAttachedService 
{
    @Autowired
    private SysContractAttachedMapper sysContractAttachedMapper;

    /**
     * 查询附件管理
     * 
     * @param contractId 附件管理主键
     * @return 附件管理
     */
    @Override
    public SysContractAttached selectSysContractAttachedByContractId(Long contractId)
    {
        return sysContractAttachedMapper.selectSysContractAttachedByContractId(contractId);
    }

    /**
     * 查询附件管理列表
     * 
     * @param sysContractAttached 附件管理
     * @return 附件管理
     */
    @Override
    public List<SysContractAttached> selectSysContractAttachedList(SysContractAttached sysContractAttached)
    {
        return sysContractAttachedMapper.selectSysContractAttachedList(sysContractAttached);
    }

    /**
     * 新增附件管理
     * 
     * @param sysContractAttached 附件管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysContractAttached(SysContractAttached sysContractAttached)
    {
        int rows = sysContractAttachedMapper.insertSysContractAttached(sysContractAttached);
        insertSysContract(sysContractAttached);
        return rows;
    }

    /**
     * 修改附件管理
     * 
     * @param sysContractAttached 附件管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysContractAttached(SysContractAttached sysContractAttached)
    {
        sysContractAttachedMapper.deleteSysContractByContractId(sysContractAttached.getContractId());
        insertSysContract(sysContractAttached);
        return sysContractAttachedMapper.updateSysContractAttached(sysContractAttached);
    }

    /**
     * 批量删除附件管理
     * 
     * @param contractIds 需要删除的附件管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysContractAttachedByContractIds(String contractIds)
    {
        sysContractAttachedMapper.deleteSysContractByContractIds(Convert.toStrArray(contractIds));
        return sysContractAttachedMapper.deleteSysContractAttachedByContractIds(Convert.toStrArray(contractIds));
    }

    /**
     * 删除附件管理信息
     * 
     * @param contractId 附件管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysContractAttachedByContractId(Long contractId)
    {
        sysContractAttachedMapper.deleteSysContractByContractId(contractId);
        return sysContractAttachedMapper.deleteSysContractAttachedByContractId(contractId);
    }

    /**
     * 新增项目详情信息
     * 
     * @param sysContractAttached 附件管理对象
     */
    public void insertSysContract(SysContractAttached sysContractAttached)
    {
//        List<SysContract> sysContractList = sysContractAttached.getSysContractList();
//        Long contractId = sysContractAttached.getContractId();
//        if (StringUtils.isNotNull(sysContractList))
//        {
//            List<SysContract> list = new ArrayList<SysContract>();
//            for (SysContract sysContract : sysContractList)
//            {
//                sysContract.setContractId(contractId);
//                list.add(sysContract);
//            }
//            if (list.size() > 0)
//            {
//                sysContractAttachedMapper.batchSysContract(list);
//            }
//        }
    }
}
