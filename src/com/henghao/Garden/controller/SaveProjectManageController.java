package com.henghao.Garden.controller;

import com.henghao.Garden.dao.JudgeProjectMassageDao;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.project.*;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.formFilter.ProjectFormFilter;
import com.henghao.Garden.resultEntity.Result;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.service.SaveProjectManageService;
import com.henghao.Garden.util.ProjectFileUploadUtil;
import com.henghao.Garden.util.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;

/**
 * function 项目管理信息保存模块访问入口java类
 * <p>
 * date 2017.03.12
 *
 * @author 严彬荣
 */
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.POST})
@Controller
@RequestMapping("/projectManage")
public class SaveProjectManageController {
    @Resource
    private SaveProjectManageService service;
    @Resource
    private SaveFileService fileService;
    @Resource
    private JudgeProjectMassageDao judge;
    // 实例化文件保存实体类
    private Filemassage file = new Filemassage();
    // 实例化文件保存方法类
    private ProjectFileUploadUtil uploadService = ProjectFileUploadUtil
            .getInstance();
    // 实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    // 实例化表单验证
    private ProjectFormFilter formFilter = ProjectFormFilter.getInstance();
    // 实例化结果集实体类,并定义为公共结果集
    private Result result = null;

    // 添加施工人员信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveSgPersonnelMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveSgPersonnelMsgContorller(SgPersonnel msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.sgPersonnelForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveSgPersonnelMsgService(msg);
        return this.result;
    }

    // 添加项目信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveProjectMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveProjectMsgController(Project msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.projectForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveProjectMsgService(msg);
        return this.result;
    }

    // 保存我的轨迹信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveMylocusMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveMylocusController(Mylocus msg) {
        this.result = this.service.saveMylocusMsgService(msg);
        return this.result;
    }

    // 添加设备信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveEquipmentMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveEquipmentMsgController(Equipment msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.equipmentForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveEquipmentMsgService(msg);
        return this.result;
    }

    // 添加施工日志信息访问接口
    @ResponseBody
    @RequestMapping(value = "/saveConstructionLogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveConstructionLogMsgController(ConstructionLog msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.constructionLogForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveConstructionLogMsgService(msg);
        return this.result;
    }

    // 添加监理日志信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveSupervisionlogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveSupervisionlogMsgContorller(Supervisionlog msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.supervisionlogForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveSupervisionlogMsgService(msg);
        return this.result;
    }

    // 添加施工安全日志信息数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveSummaryLogMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveConstructionSafetyLogMsgController(
            ConstructionSafetyLog msg) {
        // 录入数据验证（除空格）
        boolean tip = this.formFilter.constructionSafetyLogForm(msg);
        if (tip == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        this.result = this.service.saveConstructionSafetyLogMsgService(msg);
        return this.result;
    }

    // 添加施工钱包数据访问接口
    @ResponseBody
    @RequestMapping(value = "/saveWalletMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveWalletController(Wallet msg) {
        this.result = this.service.saveWalletMsgService(msg);
        return this.result;
    }

    // 添加申报进度信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveDeclarationMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveDeclarationMsgController(HttpServletRequest req,
                                               Declaration msg) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.declarationForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        try {
            // 设置文件路径名
            LinkedList<String> list = this.uploadService
                    .DeclarationFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setFilesId(this.uuid.getUUID().toString().toString());
                // 获取用户ID
                this.file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                this.file.setPhotofile(msg.getFilesId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统正忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("文件上传失败，请重试", 1);
            return this.result;
        }
        // 文件上传成功后保存申报信息数据
        this.result = this.service.saveDeclarationMsgService(msg);
        return this.result;
    }

    // 保存会审结果信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveHsResultMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveHsResultMsgController(HttpServletRequest req, HsResult msg) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.hsResultForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        // 判断会审结果信息数据是否存在
        int exist = this.judge.judgeHsResultMsg(msg.getUid(), msg.getPid());
        if (exist > 0) {
            this.result = new Result("此项目会审信息已存在，请勿重复添加", 1);
            return this.result;
        }
        try {
            // 设置文件路径名
            LinkedList<String> list = this.uploadService.HsResultFileSave(req);
            if (list.size() > 0) {
                // 设置文件编号
                msg.setHsImgId(this.uuid.getUUID().toString());
                // 获取用户ID
                this.file.setUid(msg.getUid());
                // 将获取的文件编号保存到文件信息表中
                this.file.setPhotofile(msg.getHsImgId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件上传成功后保存会审结果信息
        this.result = this.service.saveHsResultMsgService(msg);
        return this.result;
    }

    // 保存开工报告信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveKgReportMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveKgReportMsgController(HttpServletRequest req, KgReport msg) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.kgReportForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        // 检查是否存在相关开工报告信息
        int exist = this.judge.judgeKgReportMsg(msg.getUid(), msg.getPid());
        if (exist > 0) {
            this.result = new Result("此项目已存在开工报告，请勿重复添加", 1);
            return this.result;
        }
        try {
            // 设置文件路径
            String kgFile = this.uploadService.kgReportSave(req);
            if (kgFile == null) {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            } else {
                msg.setKgDocument(kgFile);
                this.result = this.service.saveKgReportMsgService(msg);
                return this.result;
            }
        } catch (IOException e) {
            this.result = new Result("文件上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
    }

    // 添加工序报验信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveCheckoutMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveCheckoutMsgController(Checkout msg, HttpServletRequest req) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.checkoutForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        try {
            // 设置文件路径
            LinkedList<String> list = this.uploadService.checkoutFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setGxImgId(this.uuid.getUUID().toString());
                // 获取用户ID
                this.file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                this.file.setPhotofile(msg.getGxImgId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件信息保存成功后保存工序报验信息
        this.result = this.service.saveCheckoutMsgService(msg);
        return this.result;
    }

    // 添加现场勘探信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveProspectMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveProspectMsgController(Prospect msg, HttpServletRequest req) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.prospectForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        try {
            // 设置文件路径
            LinkedList<String> list = this.uploadService.ProspectFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setXcSituationId(this.uuid.getUUID().toString());
                // 获取用户id
                file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                file.setPhotofile(msg.getXcSituationId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;

            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件信息保存成功后保存现场勘探信息
        this.result = this.service.saveProspectMsgService(msg);
        return this.result;
    }

    // 添加供货商信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveSupplierMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveSupplierMsgController(Supplier msg, HttpServletRequest req) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.supplierForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        try {
            // 设置文件路径
            LinkedList<String> list = this.uploadService.SupplierFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setEpCompactId(this.uuid.getUUID().toString());
                // 获取用户ID
                file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                file.setPhotofile(msg.getEpCompactId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;

            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件信息保存成功后保存供货商信息
        this.result = this.service.saveSupplierMsgService(msg);
        return this.result;
    }

    // 添加变更管理信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveAlterationMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveAlterationMsgController(Alteration msg,
                                              HttpServletRequest req) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.alterationForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        try {
            // 设置文件路经
            LinkedList<String> list = this.uploadService
                    .AlterationFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setFiles(this.uuid.getUUID().toString());
                // 获取用户id
                file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                file.setPhotofile(msg.getFiles());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;

            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件信息保存成功后保存变更管理信息
        this.result = this.service.saveAlterationMsgService(msg);
        return this.result;
    }

    // 添加技术交底信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveTechnologyMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveTechnologyMsgController(HttpServletRequest req,
                                              Technology msg) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.technologyForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        // 检查是否存在相关技术交底信息
        int exist = this.judge.judgeTechnologyMsg(msg.getUid(), msg.getPid());
        if (exist > 0) {
            this.result = new Result("此项目已存在技术交底信息，请勿重复添加", 1);
            return this.result;
        }
        try {
            // 设置文件路径
            LinkedList<String> list = this.uploadService
                    .TechnologyFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setPhotoId(this.uuid.getUUID().toString());
                // 获取用户编号
                file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                file.setPhotofile(msg.getPhotoId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.result = new Result("图片上传失败，请重试", 1);
            return this.result;
        }
        // 文件信息保存成功后保存技术交底信息
        this.result = this.service.saveTechnologyMsgService(msg);
        return this.result;
    }

    // 保存项目结算信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveSettlementMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveSettlementMsgController(HttpServletRequest req,
                                              Settlement msg) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.settlementForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        // 检查是否存在相关项目结算信息
        int exist = this.judge.judgeSettlementMsg(msg.getUid(), msg.getPid());
        if (exist > 0) {
            this.result = new Result("此项目已存在项目结算，请勿重复添加", 1);
            return this.result;
        }
        try {
            // 设置文件路径名
            LinkedList<String> list = this.uploadService
                    .SettlementFileSave(req);
            if (list.size() > 0) {
                // 设置文件编号
                msg.setSettlementBookId(this.uuid.getUUID().toString());
                // 获取用户ID
                this.file.setUid(msg.getUid());
                // 将设置的文件编号保存到文件信息表中
                this.file.setPhotofile(msg.getSettlementBookId());
                boolean tip = this.fileService.SaveFileMassage(list, file, req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                    return this.result;
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            this.result = new Result("图片上传失败！请重试", 1);
            e.printStackTrace();
            return this.result;
        }
        // 文件上传成功后保存结算信息
        this.result = this.service.saveSettlementMsgService(msg);

        return this.result;
    }

    // 添加竣工验收信息数据访问接口
    @SuppressWarnings("static-access")
    @ResponseBody
    @RequestMapping(value = "/saveFinalacceptanceMsg", produces = "application/json;charset=utf-8", method = {RequestMethod.POST})
    public Result saveFinalacceptanceMsgController(Finalacceptance msg,
                                                   HttpServletRequest req) {
        // 录入数据验证（除空格）
        boolean tips = this.formFilter.finalacceptanceForm(msg);
        if (tips == false) {
            return new Result("输入有误，请查正确后重试！", 5);
        }
        // 检查是否存在相关竣工验收信息
        int exist = this.judge.judgeFinalacceptanceMsg(msg.getUid(),
                msg.getPid());
        if (exist > 0) {
            this.result = new Result("此项目已存在竣工验收信息，请勿重复添加", 1);
            return this.result;
        }
        try {
            // 设置上传文件存放路径
            LinkedList<String> list = this.uploadService
                    .FinalacceptanceFileSave(req);
            if (list.size() > 0) {
                // 设置文件路径编号
                msg.setCompletionDrawingId(this.uuid.getUUID().toString());
                // 获取用户编号
                this.file.setUid(msg.getUid());
                // 将设置的文件路径编号保存到文件信息表中
                this.file.setPhotofile(msg.getCompletionDrawingId());
                boolean tip = this.fileService.SaveFileMassage(list, this.file,
                        req);
                if (tip == false) {
                    this.result = new Result("系统繁忙，请稍后重试", 1);
                }
            } else {
                this.result = new Result("文件为空或格式不正确", 1);
                return this.result;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            this.result = new Result("上传文件失败，请重试", 1);
            return this.result;
        }
        // 文件上传成功后保存竣工验收信息
        this.result = this.service.saveFinalacceptanceMsgService(msg);
        return this.result;
    }
}
