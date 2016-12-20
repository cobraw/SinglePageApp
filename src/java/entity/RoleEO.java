/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wuliming
 */
@Entity
@Table(name="role")
public class RoleEO implements Serializable {

    @Id
    private Integer id;
    private String code;
    private String name;
    private Collection<MenuEO> menus = new ArrayList<MenuEO>();

    public RoleEO() {

    }

    public RoleEO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the menus
     */
    public Collection<MenuEO> getMenus() {
        return menus;
    }

    /**
     * @param menus the menus to set
     */
    public void setMenus(Collection<MenuEO> menus) {
        this.menus = menus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
