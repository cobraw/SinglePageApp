/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import dataService.UserService;
import entity.RoleEO;
import entity.UserEO;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author wuliming
 */
@ManagedBean(name = "login")
@RequestScoped
public class loginView {

    private String userid;
    private String password;
    MenuModel menuModel;

    @ManagedProperty(value = "#{userService}")    
    private UserService userService;

    public loginView() {
        //userService = new UserService();
    }

    public boolean login() {
        UserEO u = userService.findUser(userid);
        return u.getPassword().equals(password);
    }

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
