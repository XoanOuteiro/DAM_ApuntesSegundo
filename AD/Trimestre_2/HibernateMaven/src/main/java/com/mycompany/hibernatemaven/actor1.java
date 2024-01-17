package com.mycompany.hibernatemaven;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22danielpc
 */

@Entity
@Table(name="actor", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"actor_id"})})

public class actor1 {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id", nullable=false, unique=true, length=11)
	private int actor_id;
    
    @Column(name="first_name", length=20, nullable=true)
	private String first_name;
    
    @Column(name="last_name", length=20, nullable=true)
	private String last_name;
    
    @Column(name="last_update", nullable=true)
	private Date last_update;

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public int getActor_id() {
        return actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getLast_update() {
        return last_update;
    }
    
    
    
}
