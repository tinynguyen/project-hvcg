package com.congdat.notaryweb.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
abstract class AbstractModel {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@Column(name = "created_date", nullable = false)
		private Date createdDate;

		@Column(name = "created_by")
		private String createdBy;

		@Column(name = "modified_date")
		private Date modifiedDate;

		@Column(name = "modified_by")
		private String modifiedBy;
}
