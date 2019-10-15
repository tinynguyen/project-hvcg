package com.congdat.notaryweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "likes")
public class Like extends AbstractModel {

		@Column(name = "user_id")
		private Long userId;

		@Column(name = "news_id")
		private Long newsId;

		@Column(name = "like_type")
		private int likeType;

		@ManyToMany(mappedBy = "userLikes")
		private List<User> users;

		@ManyToMany(mappedBy = "newsLikes")
		private List<News> news;
}
