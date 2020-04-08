package com.neo.model;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zhuyf
 * @since 2020-04-02
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;


   
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

 
}
