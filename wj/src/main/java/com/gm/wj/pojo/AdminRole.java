package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
    String desc_;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc_() {
        return desc_;
    }

    public void setDesc_(String desc_) {
        this.desc_ = desc_;
    }
}
