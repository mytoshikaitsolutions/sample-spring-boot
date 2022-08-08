package com.alpha.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class DeafultEntity {

	@Column(name = "createdOn")
	private String createdOn;
    
}
