package com.henghao.Garden.dao;

/**
 * function 后台判断添加项目信息是否存在访问数据是否存在库Java接口类
 * <p>
 * date 2017.03.20
 *
 * @author 严彬荣
 */
public interface JudgeProjectMassageDao {
    // 判断会审结果信息数据是否存在dao接口
    public int judgeHsResultMsg(String uid, int pid);

    // 判断开工报告信息数据是否存在dao接口
    public int judgeKgReportMsg(String uid, int pid);

    // 判断技术交底信息dao接口
    public int judgeTechnologyMsg(String uid, int pid);

    // 判断结算信息数据是否存在dao接口
    public int judgeSettlementMsg(String uid, int pid);

    // 判断竣工验收信息数据是否存在dao接口
    public int judgeFinalacceptanceMsg(String uid, int pid);

}
