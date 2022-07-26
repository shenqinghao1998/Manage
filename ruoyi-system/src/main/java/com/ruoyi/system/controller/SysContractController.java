package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.CalculateDateUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.system.domain.SysAttachment;
import com.ruoyi.system.domain.SysPayment;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysContract;
import com.ruoyi.system.service.ISysContractService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目Controller
 * 
 * @author SQH
 * @date 2022-07-26
 */
@Controller
@RequestMapping("/system/contract")
public class SysContractController extends BaseController
{
    private String prefix = "system/contract";

    @Autowired
    private ISysContractService sysContractService;

    @Autowired
    private ServerConfig serverConfig;

    private static final String FILE_DELIMETER = ",";

    /**
     * 插入的附件列表
     */

    private List<SysAttachment> attachments = new ArrayList<>();


    @RequiresPermissions("system:contract:view")
    @GetMapping()
    public String contract()
    {
        return prefix + "/contract";
    }

    /**
     * 查询项目列表
     */
    @RequiresPermissions("system:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysContract sysContract)
    {
        startPage();
        List<SysContract> list = sysContractService.selectSysContractList(sysContract);
        return getDataTable(list);
    }

    @RequiresPermissions("system:contract:list")
    @PostMapping("/detailList")
    @ResponseBody
    public TableDataInfo detailList(SysContract sysContract) {
        List<SysPayment> sysPayments = sysContractService.selectSysDetailContractList(sysContract);
        return getDataTable(sysPayments);
    }
    /**
     * 导出项目列表
     */
    @RequiresPermissions("system:contract:export")
    @Log(title = "项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysContract sysContract)
    {
        List<SysContract> list = sysContractService.selectSysContractList(sysContract);
        ExcelUtil<SysContract> util = new ExcelUtil<SysContract>(SysContract.class);
        return util.exportExcel(list, "项目数据");
    }

    /**
     * 新增项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目
     */
    @RequiresPermissions("system:contract:add")
    @Log(title = "项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysContract sysContract)
    {
        int exceeded = sysContract.getExceedMonth().intValue();
        Date date = CalculateDateUtil.addDateMonths(sysContract.getConfirmDate(), exceeded);
        sysContract.setEquipmentExceeded(date);
        List<SysPayment> sysPaymentList = sysContract.getSysPaymentList();
        if (!isEmpty(sysPaymentList)) {
            BigDecimal one = new BigDecimal(1);
            for (SysPayment sysPayment : sysContract.getSysPaymentList()) {
                sysPayment.setReceiptContext(one.add(BigDecimal.valueOf(sysPayment.getTax().intValue()).multiply(BigDecimal.valueOf(0.01))).multiply(sysPayment.getActualPayment()));
            }
        }

        int result = sysContractService.insertSysContract(sysContract, (ArrayList<SysAttachment>) attachments);
        attachments.clear();

        return toAjax(result);
    }

    /**
     * 修改项目
     */
    @RequiresPermissions("system:contract:edit")
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysContract sysContract = sysContractService.selectSysContractByContractId(contractId);
        mmap.put("sysContract", sysContract);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目
     */
    @RequiresPermissions("system:contract:edit")
    @Log(title = "项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysContract sysContract)
    {
        int exceeded = sysContract.getExceedMonth().intValue();
        Date date = CalculateDateUtil.addDateMonths(sysContract.getConfirmDate(), exceeded);
        sysContract.setEquipmentExceeded(date);
        List<SysPayment> sysPaymentList = sysContract.getSysPaymentList();
        if (!isEmpty(sysPaymentList)) {
            BigDecimal one = new BigDecimal(1);
            for (SysPayment sysPayment : sysContract.getSysPaymentList()) {
                sysPayment.setReceiptContext(one.add(BigDecimal.valueOf(sysPayment.getTax().intValue()).multiply(BigDecimal.valueOf(0.01))).multiply(sysPayment.getActualPayment()));
            }
        }

        int result = sysContractService.insertSysContract(sysContract, (ArrayList<SysAttachment>) attachments);
        attachments.clear();

        return toAjax(result);
    }

    /**
     * 删除项目
     */
    @RequiresPermissions("system:contract:remove")
    @Log(title = "项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysContractService.deleteSysContractByContractIds(ids));
    }

    /**
     * 判断获得的 sysPaymentList是否为空
     * @param sysPaymentList
     * @return 不为空返回false，空返回true
     */
    private boolean isEmpty(List<SysPayment> sysPaymentList){
        if (sysPaymentList != null && !sysPaymentList.isEmpty()) {
            return false;
        }

        return true;
    }


    @GetMapping("/upload")
    public String upload()
    {
        return prefix + "/upload";
    }
    @PostMapping("/uploads")
    @ResponseBody
    public AjaxResult uploadFiles(List<MultipartFile> files) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            List<String> urls = new ArrayList<String>();
            List<String> fileNames = new ArrayList<String>();
            List<String> newFileNames = new ArrayList<String>();
            List<String> originalFilenames = new ArrayList<String>();
            for (MultipartFile file : files)
            {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                urls.add(url);
                fileNames.add(fileName);
                newFileNames.add(FileUtils.getName(fileName));
                originalFilenames.add(file.getOriginalFilename());

                SysAttachment attachment = new SysAttachment(FileUtils.getName(fileName), url);
                attachments.add(attachment);
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }
}
