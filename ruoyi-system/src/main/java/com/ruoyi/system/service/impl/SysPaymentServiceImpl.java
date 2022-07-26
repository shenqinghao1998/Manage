package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.mapper.SysPaymentMapper;
import com.ruoyi.system.domain.SysPayment;
import com.ruoyi.system.service.ISysPaymentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 付款Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-22
 */
@Service
public class SysPaymentServiceImpl implements ISysPaymentService 
{
    @Autowired
    private SysPaymentMapper sysPaymentMapper;

    /**
     * 查询付款
     * 
     * @param contractId 付款主键
     * @return 付款
     */
    @Override
    public SysPayment selectSysPaymentByContractId(Long contractId)
    {
        return sysPaymentMapper.selectSysPaymentByContractId(contractId);
    }

    /**
     * 查询付款列表
     * 
     * @param sysPayment 付款
     * @return 付款
     */
    @Override
    @DataScope(deptAlias = "pay",userAlias = "pay")
    public List<SysPayment> selectSysPaymentList(SysPayment sysPayment)
    {
        return sysPaymentMapper.selectSysPaymentList(sysPayment);
    }

    /**
     * 新增付款
     * 
     * @param sysPayment 付款
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysPayment(SysPayment sysPayment)
    {
        int rows = sysPaymentMapper.insertSysPayment(sysPayment);
        insertSysContract(sysPayment);
        return rows;
    }

    /**
     * 修改付款
     * 
     * @param sysPayment 付款
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysPayment(SysPayment sysPayment)
    {
//        sysPaymentMapper.deleteSysContractByContractId(sysPayment.getContractId());
//        insertSysContract(sysPayment);
        return sysPaymentMapper.updateSysPayment(sysPayment);
    }

    /**
     * 批量删除付款
     * 
     * @param contractIds 需要删除的付款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysPaymentByContractIds(String contractIds)
    {
        sysPaymentMapper.deleteSysContractByContractIds(Convert.toStrArray(contractIds));
        return sysPaymentMapper.deleteSysPaymentByContractIds(Convert.toStrArray(contractIds));
    }

    /**
     * 删除付款信息
     * 
     * @param contractId 付款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysPaymentByContractId(Long contractId)
    {
        sysPaymentMapper.deleteSysContractByContractId(contractId);
        return sysPaymentMapper.deleteSysPaymentByContractId(contractId);
    }

    /**
     * 新增项目信息
     * 
     * @param sysPayment 付款对象
     */
    public void insertSysContract(SysPayment sysPayment)
    {
//        Long contractId = sysPayment.getContractId();
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
//                sysPaymentMapper.batchSysContract(list);
//            }
//        }
    }
}
