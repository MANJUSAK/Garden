package com.henghao.Garden.dao.daolmpl;

import com.henghao.Garden.dao.userManageDao;
import com.henghao.Garden.entity.user.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * function 登录注册模块访问数据库Java类
 *
 * @author 严彬荣
 */
@Repository
public class UserManageDaolmpl implements userManageDao {

    @Resource
    private SessionFactory factory;

    // 用户登陆验证dao方法
    @Override
    public Users login(Users user) {
        DetachedCriteria dc = DetachedCriteria.forClass(Users.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("u.uid").as("uid"));
        field.add(Property.forName("u.username").as("username"));
        field.add(Property.forName("u.tel").as("tel"));
        dc.add(Restrictions.or(Restrictions.eq("username", user.getUsername()),
                Restrictions.eq("tel", user.getUsername())));
        dc.add(Restrictions.eq("password", user.getPassword()));
        dc.setProjection(field);
        return (Users) dc
                .getExecutableCriteria(this.factory.getCurrentSession())
                .setResultTransformer(Transformers.aliasToBean(Users.class))
                .uniqueResult();
    }

    // 管理员登陆dao方法
    @Override
    public Admin roleLogin(Admin role) {
        DetachedCriteria dc = DetachedCriteria.forClass(Admin.class, "r");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("r.aid").as("aid"));
        field.add(Property.forName("r.userName").as("userName"));
        field.add(Property.forName("r.tel").as("tel"));
        dc.add(Restrictions.or(Restrictions.eq("userName", role.getUserName()),
                Restrictions.eq("tel", role.getUserName())));
        dc.add(Restrictions.eq("passWord", role.getPassWord()));
        dc.setProjection(field);
        return (Admin) dc
                .getExecutableCriteria(this.factory.getCurrentSession())
                .setResultTransformer(Transformers.aliasToBean(Admin.class))
                .uniqueResult();
    }

    // 检查用户名是否重复
    @Override
    public Users checkUserName(String userName) {
        DetachedCriteria dc = DetachedCriteria.forClass(Users.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Projections.property("u.uid").as("uid"));
        dc.add(Restrictions.eq("username", userName));
        dc.setProjection(field);
        return (Users) dc
                .getExecutableCriteria(this.factory.getCurrentSession())
                .setResultTransformer(Transformers.aliasToBean(Users.class))
                .uniqueResult();
    }

    // 检查手机号是否重复dao方法
    @Override
    public Users checkUserTel(String tel) {
        DetachedCriteria dc = DetachedCriteria.forClass(Users.class, "u");
        ProjectionList field = Projections.projectionList();
        field.add(Projections.property("u.uid").as("uid"));
        dc.add(Restrictions.eq("tel", tel));
        dc.setProjection(field);
        return (Users) dc
                .getExecutableCriteria(this.factory.getCurrentSession())
                .setResultTransformer(Transformers.aliasToBean(Users.class))
                .uniqueResult();
    }

    // 用户签到次数dao方法
    @Override
    public BigInteger report(String uid, String date) {
        return (BigInteger) this.factory
                .getCurrentSession()
                .createSQLQuery(
                        "select count(uid) from sites where uid=:uid and dates like :date")
                .setParameter("uid", uid)
                .setParameter("date", "%" + date + "%").uniqueResult();
    }

    // 用户注册dao方法
    @Override
    public void register(Users user) throws Exception {
        this.factory.getCurrentSession().save(user);
        this.factory.getCurrentSession().clear();
    }

    // 管理员注册dao方法
    @Override
    public void roleRegister(Admin role) throws Exception {
        this.factory.getCurrentSession().save(role);
        this.factory.getCurrentSession().clear();
    }

    // 用户签到dao方法
    @Override
    public void report(Sites site) throws Exception {
        this.factory.getCurrentSession().save(site);
        this.factory.getCurrentSession().clear();
    }

    /**
     * 功能：检查系统权限数据是否存在（防止服务器重启再次初始化权限数据）dao方法
     *
     * @return Boolean
     * @parameter 无
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Rights> queryRights() {
        DetachedCriteria dc = DetachedCriteria.forClass(Rights.class);
        return dc.getExecutableCriteria(this.factory.getCurrentSession()).list();
    }

    /**
     * 初始化用户具有系统权限dao接口
     *
     * @parameter var 用户权限等级
     * <p>
     * return 权限等级编号
     */
    @Override
    public Grade queryRightsById(int var) {
        DetachedCriteria dc = DetachedCriteria.forClass(Grade.class, "g");
        ProjectionList field = Projections.projectionList();
        field.add(Property.forName("g.roleId").as("roleId"));
        dc.add(Restrictions.eq("level", var));
        dc.setProjection(field);
        return (Grade) dc.getExecutableCriteria(this.factory.getCurrentSession())
                .setResultTransformer(Transformers.aliasToBean(Grade.class))
                .uniqueResult();
    }

    /**
     * 功能：初始化系统权限管理dao接口
     *
     * @return 无
     * @parameter rights 权限信息，grade 权限等级信息
     */
    @Override
    public void rightsInitialization(List<Rights> rights, List<Grade> grade) throws Exception {
        for (int i = 0, length = rights.size(); i < length; ++i) {
            this.factory.getCurrentSession().save(rights.get(i));
            this.factory.getCurrentSession().save(grade.get(i));
            this.factory.getCurrentSession().clear();
        }
    }
}
