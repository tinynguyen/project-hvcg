package com.congdat.notaryweb.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
@JsonIdentityInfo(
								generator = ObjectIdGenerators.PropertyGenerator.class,
								property = "id")
public class Role extends AbstractModel {

		@Column(name = "name", nullable = false)
		private String name;

		@Column(name = "role", nullable = false)
		private String role;

		@ManyToMany(mappedBy = "roles")
		private List<User> users = new ArrayList<>();
}
