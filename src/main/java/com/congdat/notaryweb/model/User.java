package com.congdat.notaryweb.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonIdentityInfo(
								generator = ObjectIdGenerators.PropertyGenerator.class,
								property = "id")
public class User extends BaseModel {

		@Column(name = "full_name", nullable = false)
		private String fullName;

		@Column(name = "username", unique = true, nullable = false)
		private String username;

		@Column(name = "password", nullable = false)
		private String password;

		@Column(name = "email", unique = true, nullable = false)
		private String email;

		@Column(name = "enabled")
		private int enabled;

		@Column(name = "avatar")
		private String avatar;

		/* Mapping relationship */
		@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER)
		@JoinTable(name = "users_roles",
										joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
										inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
		@JsonIgnore
		private List<Role> roles = new ArrayList<>();

		@OneToMany(mappedBy = "user")
		private List<News> news;

		@ManyToMany(targetEntity = Like.class)
		@JoinTable(name = "users_likes",
										joinColumns = @JoinColumn(name = "user_id"),
										inverseJoinColumns = @JoinColumn(name = "like_id"))
		private List<Like> userLikes;

}

