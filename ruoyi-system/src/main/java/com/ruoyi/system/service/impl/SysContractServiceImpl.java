package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysPayment;
import com.ruoyi.system.mapper.SysContractMapper;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.service.ISysContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 项目Service业务层处理
 * 
 * @author SQH
 * @date 2022-07-26
 */
@Service
public class SysContractServiceImpl implements ISysContractService 
{
    @Autowired
    private SysContractMapper sysContractMapper;

    /**
     * 查询项目
     * 
     * @param contractId 项目主键
     * @return 项目
     */
    @Override
    public SysContract selectSysContractByContractId(Long contractId)
    {
        return sysContractMapper.selectSysContractByContractId(contractId);
    }

    /**
     * 查询项目列表
     * 
     * @param sysContract 项目
     * @return 项目
     */
    @Override
    public List<SysContract> selectSysContractList(SysContract sysContract)
    {
        return sysContractMapper.selectSysContractList(sysContract);
    }

    /**
     * 查询子表详情
     * @param sysContract
     * @return
     */
    public List<SysPayment> selectSysDetailContractList(SysContract sysContract) {
        SysContract contracts = sysContractMapper.selectSysContractByContractId(sysContract.getContractId());
        return contracts.getSysPaymentList();
    }

    /**
     * 新增项目
     * 
     * @param sysContract 项目
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysContract(SysContract sysContract)
    {
        int rows = sysContractMapper.insertSysContract(sysContract);
        insertSysPayment(sysContract);
        return rows;
    }


    public int insertSysContract(SysContract sysContract,ArrayList<SysAttachment> attachments)
    {
        int rows = sysContractMapper.insertSysContract(sysContract);
        insertSysPayment(sysContract);
        insertSysAttachment(sysContract,attachments);
        return rows;
    }
    /**
     * 修改项目
     * 
     * @param sysContract 项目
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysContract(SysContract sysContract)
    {
        sysContractMapper.deleteSysPaymentByPaymentId(sysContract.getContractId());
        insertSysPayment(sysContract);
        return sysContractMapper.updateSysContract(sysContract);
    }

    /**
     * 批量删除项目
     * 
     * @param contractIds 需要删除的项目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysContractByContractIds(String contractIds)
    {
        sysContractMapper.deleteSysPaymentByPaymentIds(Convert.toStrArray(contractIds));
        return sysContractMapper.deleteSysContractByContractIds(Convert.toStrArray(contractIds));
    }

    /**
     * 删除项目信息
     * 
     * @param contractId 项目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysContractByContractId(Long contractId)
    {
        sysContractMapper.deleteSysPaymentByPaymentId(contractId);
        return sysContractMapper.deleteSysContractByContractId(contractId);
    }

    /**
     * 新增付款信息
     * 
     * @param sysContract 项目对象
     */
    public void insertSysPayment(SysContract sysContract)
    {
        List<SysPayment> sysPaymentList = sysContract.getSysPaymentList();
        Long contractId = sysContract.getContractId();
        if (StringUtils.isNotNull(sysPaymentList))
        {
            List<SysPayment> list = new ArrayList<SysPayment>();
            for (SysPayment sysPayment : sysPaymentList)
            {
                sysPayment.setPaymentId(contractId);
                list.add(sysPayment);
            }
            if (list.size() > 0)
            {
                sysContractMapper.batchSysPayment(list);
            }
        }
    }

    public void insertSysAttachment(SysContract sysContract, ArrayList<SysAttachment> sysAttachment) {
        Long contractId = sysContract.getContractId();
        String contractName = sysContract.getContractName();
        if (StringUtils.isNotNull(sysAttachment)) {
            List<SysAttachment> list = new ArrayList<SysAttachment>();

            for (SysAttachment attachment : sysAttachment) {
                attachment.setAttachmentId(contractId);
                attachment.setContractName(contractName);
                list.add(attachment);
            }

            if (list.size() > 0) {
                sysContractMapper.batchAttachment(list);
            }

        }
    }
}
