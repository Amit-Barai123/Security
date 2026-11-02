package com.amit.spingSecurity.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Set<AppUser> users = new HashSet<AppUser>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name ="role_permissions",
	joinColumns = @JoinColumn(name ="role_id"),
	inverseJoinColumns = @JoinColumn(name="permission_id")
			)
	private Set<Permission> permissions = new HashSet<>();
	
	
	public Role (String name) {
		this.name= name;
	}
	
}
