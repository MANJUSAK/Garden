package com.henghao.Garden.controller;

import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.project.KgReport;
import com.henghao.Garden.entity.user.Wallet;
import com.henghao.Garden.service.FileDownloadService;
import com.henghao.Garden.service.QueryProjectManageService;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.util.CreateExcelUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * function 下载文件模块访问入口Java类
 * <p>
 * date 2017.03.18
 *
 * @author 严彬荣
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

    @Resource
    private FileDownloadService fileService;
    @Resource
    private QueryProjectManageService service;
    @Resource
    private SaveFileService savefileService;
    // 实例化Excel工具类
    private CreateExcelUtil excel = CreateExcelUtil.getInstance();
    // 实例化Excel文件实体类
    private Excelmassage file = new Excelmassage();
    private File files = null;

    // 开工报告下载访问接口
    @RequestMapping(value = "/kgReportFile", method = {RequestMethod.POST})
    public ResponseEntity<byte[]> kgReportFileDownloadController(
            @RequestParam("uid") String uid, @RequestParam("kid") int kid, HttpServletRequest request) throws IOException {
        // 获取数据库文件路径信息
        KgReport msg = this.fileService.queryKgReportFilePathService(uid, kid);
        if (msg != null) {
            // 获取服务器存放路径
            String rootpath = request.getSession().getServletContext()
                    .getRealPath("");
            // 截取文件下载服务器路径
            String tomcatPath = rootpath.substring(0,
                    rootpath.lastIndexOf("Garden"));
            // 获取完整文件路径
            String path = tomcatPath + msg.getKgDocument();
            // 获取文件
            this.files = new File(path);
            // 为了解决中文名称乱码问题
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String(
                    this.files.getName().getBytes("UTF-8"), "iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(
                    FileUtils.readFileToByteArray(this.files), headers,
                    HttpStatus.CREATED);
        } else {
            return null;
        }

    }

    // excel表格下载访问接口
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/walletExcel", method = {RequestMethod.POST})
    public ResponseEntity<byte[]> walletExcelDownloadController(@RequestParam("uid") String uid, HttpServletRequest request)
            throws IOException {
        List<Wallet> list = (List<Wallet>) this.service.queryWalletMsgService(
                uid).getData();
        if (list != null) {
            // 获取服务器存放路径
            String rootpath = request.getSession().getServletContext()
                    .getRealPath("");
            // 截取文件下载服务器路径
            String tomcatPath = rootpath.substring(0,
                    rootpath.lastIndexOf("Garden"));
            // 查询是否存在文件
            Excelmassage excel = this.service.queryFileMsgService(uid);
            // 文件存在
            if (excel != null) {
                // 获取存放数据库文件路径信息
                String excelPath = this.excel.downloadWalletExcel(request,
                        list, excel.getPath());
                // 获取下载文件完整路径
                String path = tomcatPath + excelPath;
                // 获取文件
                this.files = new File(path);
                // 为了解决中文名称乱码问题
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDispositionFormData("attachment", new String(
                        this.files.getName().getBytes("UTF-8"), "iso-8859-1"));
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(
                        FileUtils.readFileToByteArray(this.files), headers,
                        HttpStatus.CREATED);
            } else {
                // 文件不存在
                String excelPath = this.excel.downloadWalletExcel(request,
                        list, null);
                // 获取用户ID
                this.file.setUid(uid);
                // 获取需要存放数据库的文件路径
                this.file.setPath(excelPath);
                // 将文件信息保存到数据库Excel信息表中
                this.savefileService.SaveExcelmassage(this.file);
                // 获取下载文件完整路径
                String path = tomcatPath + excelPath;
                // 获取文件
                this.files = new File(path);
                // 为了解决中文名称乱码问题
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDispositionFormData("attachment", new String(
                        this.files.getName().getBytes("UTF-8"), "iso-8859-1"));
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                return new ResponseEntity<byte[]>(
                        FileUtils.readFileToByteArray(this.files), headers,
                        HttpStatus.CREATED);
            }

        } else {
            return null;
        }

    }

}
