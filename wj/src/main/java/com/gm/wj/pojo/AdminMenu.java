package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin_menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String path;
    String icon;
    String component;

    @OneToMany
    @JoinColumn(name = "parent_id")
    @OrderBy("sequence asc")
    List<AdminMenu> children;

    @Transient
    MenuMeta menuMeta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public List<AdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }

    public MenuMeta getMenuMeta() {
        return menuMeta;
    }

    public void setMenuMeta(MenuMeta menuMeta) {
        this.menuMeta = menuMeta;
    }
}
