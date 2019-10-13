package com.congdat.notaryweb.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
@JsonIdentityInfo(
								generator = ObjectIdGenerators.PropertyGenerator.class,
								property = "id")
public class News extends BaseModel {

		@Column(name = "title", nullable = false)
		private String title;

		@Column(name = "thumbnail")
		private String thumbnail;

		@Column(name = "description", nullable = false)
		private String description;

		@Column(name = "content", nullable = false)
		private String content;

		@ManyToOne
		@JoinColumn(name = "user_id")
//		@JsonManagedReference
		private User user;

		@ManyToMany(targetEntity = Like.class)
		@JoinTable(name = "news_likes",
										joinColumns = @JoinColumn(name = "news_id"),
										inverseJoinColumns = @JoinColumn(name = "like_id"))
		private List<Like> newsLikes;

		@ManyToMany(targetEntity = Category.class)
		@JoinTable(name = "news_categories",
										joinColumns = @JoinColumn(name = "news_id"),
										inverseJoinColumns = @JoinColumn(name = "category_id"))
		private List<Category> categories;

}
