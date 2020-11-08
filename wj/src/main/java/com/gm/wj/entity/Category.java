package com.gm.wj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Category entity.
 *
 * @author Evan
 * @date 2019/4
 */
@Data
@Entity
@Table(name = "category")
@ToString
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * Category name in Chinese.
     */
    private String name;
}
