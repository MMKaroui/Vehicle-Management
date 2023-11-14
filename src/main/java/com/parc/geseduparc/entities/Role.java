package com.parc.geseduparc.entities;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_role")
    private Long idRole;
	private String lib_role;
	private String desc_role;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private List<User> utilisateurList;
	
	
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getLib_role() {
		return lib_role;
	}
	public void setLib_role(String lib_role) {
		this.lib_role = lib_role;
	}
	public String getDesc_role() {
		return desc_role;
	}
	public void setDesc_role(String desc_role) {
		this.desc_role = desc_role;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long idRole, String lib_role, String desc_role) {
		super();
		this.idRole = idRole;
		this.lib_role = lib_role;
		this.desc_role = desc_role;
	}
	
	 
}
