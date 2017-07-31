package com.henghao.Garden.dao;

import com.henghao.Garden.entity.fileMassage.Compactmassage;
import com.henghao.Garden.entity.fileMassage.Excelmassage;
import com.henghao.Garden.entity.fileMassage.Filemassage;
import com.henghao.Garden.entity.fileMassage.Talentpoolmassage;
import com.henghao.Garden.entity.user.Userfile;

import java.util.LinkedList;
import java.util.List;

/**
 * function 文件信息访问数据库接口Java类
 * <p>
 * date 2017.03.12
 *
 * @author 严彬荣
 */
public interface SaveFileDao {

    // 项目管理文件信息保存dao接口
    public StringBuilder SaveFileMassageDao(LinkedList<String> list, Filemassage msg) throws Exception;

    // 用户文件信息保存dao接口
    public void SaveUserFileMassageDao(LinkedList<String> list, Userfile msg) throws Exception;

    // excel文件信息保存dao接口
    public void SaveExcelmassageDao(Excelmassage msg) throws Exception;

    // 合同管理文件信息保存dao接口
    public StringBuilder SaveCompactmassgeDao(List<String> list, Compactmassage msg) throws Exception;

    // 人才库文件数据保存dao接口
    public StringBuilder saveTalentpoolmassageDao(List<String> list, Talentpoolmassage msg) throws Exception;
}
