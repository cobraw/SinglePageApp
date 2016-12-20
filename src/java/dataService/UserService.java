/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataService;

import entity.MenuEO;
import entity.RoleEO;
import entity.UserEO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author wuliming
 */
@ManagedBean(name = "userService")
@ApplicationScoped
//@NoneScoped
public class UserService {
    private UserEO selectUser;
    //
    private List<MenuEO> menus = new ArrayList<>();
    private List<RoleEO> roles = new ArrayList<>();
    private List<UserEO> users = new ArrayList<>();

    public UserService() {

        //菜单表
        menus.add(new MenuEO("系统管理", 0, ""));
        menus.add(new MenuEO( "添加用户", 1, "addUser.xhtml"));
        menus.add(new MenuEO( "修改口令", 1, "temp.xhtml"));
        menus.add(new MenuEO( "学生管理", 0, ""));
        menus.add(new MenuEO( "添加学生", 2, "addStudent.xhtml"));
        menus.add(new MenuEO( "查询学生", 2, "temp.xhtml"));
        menus.add(new MenuEO( "课程管理", 0, ""));
        menus.add(new MenuEO( "添加课程", 3, "temp.xhtml"));
        menus.add(new MenuEO( "查询课程", 3, "temp.xhtml"));
        menus.add(new MenuEO( "选课管理", 0, ""));

        //角色表
        RoleEO role = new RoleEO("1", "系统管理员");
        ArrayList<MenuEO> m = (ArrayList<MenuEO>) role.getMenus();
        m.add(menus.get(0));
        m.add(menus.get(1));
        m.add(menus.get(2));
        roles.add(role);
        role = new RoleEO("2", "教师");
        m = (ArrayList<MenuEO>) role.getMenus();
        m.add(menus.get(0));
        m.add(menus.get(2));
        m.add(menus.get(3));
        m.add(menus.get(4));
        m.add(menus.get(5));
        m.add(menus.get(6));
        m.add(menus.get(7));
        m.add(menus.get(8));

        roles.add(role);
        role = new RoleEO("3", "学生");
        m = (ArrayList<MenuEO>) role.getMenus();
        m.add(menus.get(0));
        m.add(menus.get(2));
        m.add(menus.get(6));
        m.add(menus.get(8));
        roles.add(role);

        //用户表
        users.add(new UserEO("1001", "tom", "tom"));
        users.add(new UserEO("1002", "john", "john"));
        users.add(new UserEO("1003", "smith", "smith"));
        users.add(new UserEO("1004", "william", "william"));
        //此人拥有全部角色
        ArrayList<RoleEO> rs = (ArrayList<RoleEO>) users.get(0).getRoles();
        rs.add(roles.get(0));//管理员
        rs.add(roles.get(1));//老师
        rs.add(roles.get(2));//学生
        //此人是教师角色
        rs = (ArrayList<RoleEO>) users.get(1).getRoles();
        rs.add(roles.get(1));
        //以下两个为学生角色
        rs = (ArrayList<RoleEO>) users.get(2).getRoles();
        rs.add(roles.get(2));
        rs = (ArrayList<RoleEO>) users.get(3).getRoles();
        rs.add(roles.get(2));
    }

    public UserEO findUser(String code) {
        UserEO user = null;
        for (UserEO u : users) {
            if (u.getCode().equals(code)) {
                user = u;
            }
        }
        return user;
    }

    /**
     * @return the users
     */
    public List<UserEO> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<UserEO> users) {
        this.users = users;
    }

    /**
     * @return the selectUser
     */
    public UserEO getSelectUser() {
        return selectUser;
    }

    /**
     * @param selectUser the selectUser to set
     */
    public void setSelectUser(UserEO selectUser) {
        this.selectUser = selectUser;
    }
    public void doTest(UserEO user){
        selectUser=user;
    }
}
