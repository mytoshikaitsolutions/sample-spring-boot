package com.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name= "client", uniqueConstraints=@UniqueConstraint(columnNames={"name"}))
public class ClientEntity extends DeafultEntity {
	
	public ClientEntity() {}
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false, name = "client_id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
}