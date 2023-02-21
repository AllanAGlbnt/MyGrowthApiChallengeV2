package com.allanAsc.MyGrowthApiChallengeV2.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users_roles")
@Entity
public class UserRole {
	@Id
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "role_id")
	private Integer roleId;
	
}
