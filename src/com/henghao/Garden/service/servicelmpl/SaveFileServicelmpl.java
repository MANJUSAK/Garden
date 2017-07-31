package com.henghao.Garden.service.servicelmpl;

import com.henghao.Garden.dao.SaveFileDao;
import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.user.Userfile;
import com.henghao.Garden.service.SaveFileService;
import com.henghao.Garden.util.CompressImgUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * function 文件信息保存业务逻辑Java类
 *
 * @author 严彬荣
 */
@Service
public class SaveFileServicelmpl implements SaveFileService {
    @Resource
    private SaveFileDao dao;
    // 实例化图片压缩工具类
    private static CompressImgUtil cpl = CompressImgUtil.getInstance();
    // 源文件路径
    private static StringBuilder path = null;

    // 项目管理图片信息保存方法
    @Override
    public boolean SaveFileMassage(LinkedList<String> list, Filemassage msg,
                                   final HttpServletRequest req) {
        try {
            path = this.dao.SaveFileMassageDao(list, msg);
            // 确保线程执行压缩时变量发生错乱
            new ThreadLocal<Object>() {
                public void run() {
                    // 设置线程同步，确保线程安全
                    synchronized (this) {
                        // 执行图片压缩
                        cpl.getConpressImg(path.toString(), req);
                    }
                }
            }.run();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Excel文件信息保存方法
    @Override
    public boolean SaveExcelmassage(Excelmassage msg) {
        try {
            this.dao.SaveExcelmassageDao(msg);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // 用户文件信息保存方法
    @Override
    public boolean SaveUserFileMassage(LinkedList<String> list, Userfile msg) {
        try {
            this.dao.SaveUserFileMassageDao(list, msg);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // 合同管理图片文件数据保存方法
    @Override
    public boolean SaveCompactmassge(List<String> list, Compactmassage msg,
                                     final HttpServletRequest req) {
        try {
            path = this.dao.SaveCompactmassgeDao(list, msg);
            // 确保线程执行压缩时变量发生错乱
            new ThreadLocal<Object>() {
                public void run() {
                    // 设置线程同步，确保线程安全
                    synchronized (this) {
                        // 执行图片压缩
                        cpl.getConpressImg(path.toString(), req);
                    }
                }
            }.run();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // 人才库图片文件数据保存方法
    @Override
    public boolean SaveTalentpoolmassge(List<String> list,
                                        Talentpoolmassage msg, final HttpServletRequest req) {
        try {
            path = this.dao.saveTalentpoolmassageDao(list, msg);
            // 确保线程执行压缩时变量发生错乱
            new ThreadLocal<Object>() {
                public void run() {
                    // 设置线程同步，确保线程安全
                    synchronized (this) {
                        // 执行图片压缩
                        cpl.getConpressImg(path.toString(), req);
                    }
                }
            }.run();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
