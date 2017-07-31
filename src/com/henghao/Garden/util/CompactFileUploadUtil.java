package com.henghao.Garden.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;

/**
 * function 合同管理文件上传工具类
 * <p>
 * date 2017.04.20
 *
 * @author 严彬荣
 */
public class CompactFileUploadUtil {

    /**
     * 创建CompactFileUploadUtil工具类单例
     **/

    private volatile static CompactFileUploadUtil instance;

    private CompactFileUploadUtil() {
    }

    public static CompactFileUploadUtil getInstance() {
        if (instance == null) {
            synchronized (CompactFileUploadUtil.class) {
                if (instance == null)
                    instance = new CompactFileUploadUtil();
            }
        }
        return instance;
    }

    // 初始化公共集合
    private List<String> list = new ArrayList<String>();
    // 实例化UUID工具类
    private UUIDUtil uuid = UUIDUtil.getInstance();
    private StringBuilder sb = null;

    // 合同管理文档文件保存方法
    public String documentCompactFileUpload(MultipartFile file,
                                            HttpServletRequest req, String folder) throws Exception {
        // 解析器解析request的上下文
        String path = req.getSession().getServletContext().getRealPath("");
        String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
        String upload = "/gardenFile/compact/" + folder + "/document/"
                + new SimpleDateFormat("yyyyMMddHH").format(new Date());
        String savePath = rootpath + "/" + upload;
        String paths = null;
        if (!file.isEmpty()) {
            File file1 = new File(savePath);
            if (!file1.exists()) {
                file1.mkdirs();
            }
            String name = file.getOriginalFilename().toLowerCase();
            this.sb = new StringBuilder(name.substring(name.indexOf(".")));
            if (name.endsWith("doc") || name.endsWith("docx")
                    || name.endsWith("pdf")) {
                paths = "/" + this.uuid.getUUID().toString() + sb;
                file.transferTo(new File(file1 + paths));
                // try {
                // FileOutputStream fos = new FileOutputStream(file1 + paths);
                // InputStream ins = file.getInputStream();
                // int b = 0;
                // while ((b = ins.read()) != -1) {
                // fos.write(b);
                // }
                // fos.close();
                // ins.close();
                // } catch (Exception e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }
            } else {
                return null;
            }
        } else {
            return null;
        }
        return new StringBuilder(upload + paths).toString();
    }

    // 合同管理图片文件保存方法
    public List<String> pictureCompactFileUpload(MultipartFile[] file,
                                                 HttpServletRequest req, String folder) throws Exception {
        // 解析器解析request的上下文
        String path = req.getSession().getServletContext().getRealPath("");
        String rootpath = path.substring(0, path.lastIndexOf("Garden")) + "/";
        String upload = "/gardenFile/compact/"
                + folder
                + "/img/"
                + new SimpleDateFormat("yyyyMMddHHmmssSSSSHHmmssSSSS")
                .format(new Date());
        String savePath = rootpath + "/" + upload;
        File file1 = new File(savePath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        for (int i = 0, length = file.length; i < length; i++) {
            if (!file[i].isEmpty()) {
                String name = file[i].getOriginalFilename().toLowerCase();
                this.sb = new StringBuilder(name.substring(name.indexOf(".")));
                if (name.endsWith("jpg") || name.endsWith("jpeg")
                        || name.endsWith("png") || name.endsWith("gif")) {
                    String paths = "/" + this.uuid.getUUID() + sb;
                    file[i].transferTo(new File(file1 + paths));
                    list.add(new StringBuilder(upload + paths).toString());
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return this.list;
    }
}
