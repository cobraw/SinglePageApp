/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import dataService.UserService;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author wuliming
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class Desktop {

    private MenuModel model;
    private String url = "desktop.xhtml";

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    public Desktop() {
        //userService=new UserService();
        initData();
    }

    public MenuModel getModel() {
        
        return model;
    }

    public void addProject() {
        //AppUtil.getController().setUrl("index.xhtml");
    }

    public void setMainAreaUrl(MenuActionEvent event) {
        MenuItem menuItem = event.getMenuItem();
        //String url;
        url = menuItem.getParams().get("url").get(0);
        //AppUtil.getController().setUrl(url);
        //addMessage("Success", "url update");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public final void initData() {
        model = new DefaultMenuModel();
        //First submenu
        DefaultMenuItem item;
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");

        item = new DefaultMenuItem("Test 1");
        item.setIcon("ui-icon-home");
        item.setCommand("#{menuBean.setMainAreaUrl}");
        item.setParam("url", "TestALTER.xhtml");
        item.setUpdate(":mainarea");
        firstSubmenu.addElement(item);

        model.addElement(firstSubmenu);

        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
        item = new DefaultMenuItem("Test 2");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuBean.setMainAreaUrl}");
        item.setParam("url", "test2.xhtml");
        item.setUpdate(":mainarea");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Test 3");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuBean.setMainAreaUrl}");
        item.setParam("url", "test3.xhtml");
        item.setUpdate(":mainarea");
        secondSubmenu.addElement(item);

        item = new DefaultMenuItem("Test 4");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuBean.setMainAreaUrl}");
        item.setParam("url", "test4.xhtml");
        item.setUpdate(":mainarea");
        secondSubmenu.addElement(item);
        model.addElement(secondSubmenu);
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
}
