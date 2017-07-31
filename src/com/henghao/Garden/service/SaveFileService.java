package com.henghao.Garden.service;

import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.user.Userfile;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * function 文件信息业务逻辑接口Java类
 *
 * @author 严彬荣
 */
public interface SaveFileService {

    // 项目管理图片文件信息保存接口
    public boolean SaveFileMassage(LinkedList<String> list, Filemassage msg, HttpServletRequest req);

    // 用户文件信息保存接口
    public boolean SaveUserFileMassage(LinkedList<String> list, Userfile msg);

    // excel文件信息保存接口
    public boolean SaveExcelmassage(Excelmassage msg);

    // 合同管理图片文件信息保存接口
    public boolean SaveCompactmassge(List<String> list, Compactmassage msg, HttpServletRequest req);

    // 人才库图片文件信息保存接口
    public boolean SaveTalentpoolmassge(List<String> list, Talentpoolmassage msg, HttpServletRequest req);

}
