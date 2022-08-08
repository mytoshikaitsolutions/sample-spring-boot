package com.alpha.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name= "product", uniqueConstraints=@UniqueConstraint(columnNames={"name"}))
@SQLDelete(sql = "UPDATE product SET deleted = true where product_id =?")
@FilterDef(name = "deletedSoftProduct", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedSoftProduct", condition = "deleted = :isDeleted")
public class ProductEntity extends DeafultEntity {
	
	public ProductEntity() {}
	
	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
	@Column(length = 36, nullable = false, updatable = false, name = "product_id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
	@Builder.Default
	private boolean deleted = Boolean.FALSE;
	
}