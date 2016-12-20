/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wuliming
 */
@Entity
@Table(name="menu")
public class MenuEO implements Serializable {

    @Id
    private Integer id;//编号
    //private int code;
    private String title;//标题
    private Integer parentId;//上级编号
    private String url;//地址
    private String icon;//图标
    private int order;//顺序号

    public MenuEO() {

    }

    public MenuEO(String title, Integer parentId, String url) {
        
        this.title = title;
        this.parentId = parentId;
        this.url = url;
    }

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

       /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
