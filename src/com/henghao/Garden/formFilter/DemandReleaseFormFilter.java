package com.henghao.Garden.formFilter;

import com.henghao.Garden.entity.leasing.Equipmentleasing;
import com.henghao.Garden.entity.leasing.Recruit;
import com.henghao.Garden.entity.leasing.Seedlingmessage;

/**
 * function 需求发布表单验证工具类
 * <p>
 * date 2017.05.25
 *
 * @author 严彬荣
 */
public class DemandReleaseFormFilter {
    /* 创建本类为单例模式 */
    private volatile static DemandReleaseFormFilter instance;

    private DemandReleaseFormFilter() {
    }

    public static DemandReleaseFormFilter getInstance() {
        if (instance == null) {
            synchronized (DemandReleaseFormFilter.class) {
                if (instance == null)
                    instance = new DemandReleaseFormFilter();
            }
        }
        return instance;
    }

    // 手机号正则
    private final String TEL = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[^4,5-9]))\\d{8}$";

    // 设备租赁表单验证
    public boolean equipmentForm(Equipmentleasing msg) {
        if (msg.getTitleName() == null || msg.getContent() == null
                || msg.getContacts() == null || msg.getTel() == null
                || msg.getUid() == null) {
            return false;
        }
        if (msg.getTitleName().length() <= 0
                || msg.getTitleName().length() > 50) {
            return false;
        } else if (msg.getContent().length() <= 0
                || msg.getContent().length() > 1000) {
            return false;
        } else if (msg.getContacts().length() <= 0
                || msg.getContacts().length() > 15) {
            return false;
        } else if (!msg.getTel().matches(this.TEL)) {
            return false;
        } else if (msg.getUid().length() <= 0 || msg.getUid().length() > 32) {
            return false;
        } else {
            return true;
        }
    }

    // 苗木信息表单验证
    public boolean seedlingForm(Seedlingmessage msg) {
        if (msg.getTitleName() == null || msg.getType() == null
                || msg.getContent() == null || msg.getContacts() == null
                || msg.getTel() == null || msg.getAddress() == null
                || msg.getSupplier() == null || msg.getUid() == null || msg.getSubclass() == null) {
            return false;
        }
        if (msg.getTitleName().length() <= 0
                || msg.getTitleName().length() > 50) {
            return false;
        } else if (msg.getType().length() <= 0 || msg.getType().length() > 10) {
            return false;
        } else if (msg.getContent().length() <= 0
                || msg.getContent().length() > 1000) {
            return false;
        } else if (msg.getContacts().length() <= 0
                || msg.getContacts().length() > 15) {
            return false;
        } else if (!msg.getTel().matches(this.TEL)) {
            return false;
        } else if (msg.getAddress().length() <= 0
                || msg.getAddress().length() > 150) {
            return false;
        } else if (msg.getSupplier().length() <= 0
                || msg.getSupplier().length() > 50) {
            return false;
        } else if (msg.getSubclass().length() > 10) {
            return false;
        } else if (msg.getUid().length() <= 0 || msg.getUid().length() > 32) {
            return false;
        } else {
            return true;
        }
    }

    // 人才招聘表单验证
    public boolean recruitForm(Recruit msg) {
        if (msg.getCompanyName() == null || msg.getPosition() == null
                || msg.getContact() == null || msg.getCompanyAdress() == null
                || msg.getDetail() == null || msg.getWorkingAdress() == null
                || msg.getUid() == null) {
            return false;
        }
        if (msg.getCompanyName().length() <= 0
                || msg.getCompanyName().length() > 50) {
            return false;
        } else if (msg.getPosition().length() <= 0
                || msg.getPosition().length() > 20) {
            return false;
        } else if (msg.getDetail().length() <= 0
                || msg.getDetail().length() > 1000) {
            return false;
        } else if (msg.getCompanyAdress().length() <= 0
                || msg.getCompanyAdress().length() > 150) {
            return false;
        } else if (msg.getContact().length() <= 0
                || msg.getContact().length() > 15) {
            return false;
        } else if (msg.getWorkingAdress().length() <= 0
                || msg.getWorkingAdress().length() > 150) {
            return false;
        } else if (!msg.getTel().matches(this.TEL)) {
            return false;
        } else if (msg.getUid().length() <= 0 || msg.getUid().length() > 32) {
            return false;
        } else {
            return true;
        }
    }
}
