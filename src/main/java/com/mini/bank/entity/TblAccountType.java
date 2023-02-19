package com.mini.bank.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_account_type")
public class TblAccountType {
	@Id
	@Column(name = "type_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int typeId;
	@Column(name = "type_name")
	private String typeName;
	@OneToMany(mappedBy ="accountType")
	private Set<TblAccount> accounts;
	
	
	
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
