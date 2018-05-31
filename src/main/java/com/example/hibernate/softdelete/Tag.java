package com.example.hibernate.softdelete;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: Tag
 *
 */
@Entity
@Table(name = "tag")
@Loader(namedQuery = "Tag.findById")
@NamedQuery(
		name = "Tag.findById",
		query = "SELECT t FROM Tag t WHERE t.tagId = ?1 AND t.isDeleted = false"
)
@SQLDelete(callable = false, sql = "UPDATE Tag SET is_deleted = true WHERE tag_id = ? AND optimistic_lock_version = ?")// this must be native sql and not entity attributes instead use db column names
@Where(clause = "is_deleted = false") // this must be native sql and not entity attributes instead use db column names
public class Tag extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "tag_id_generator")
	@SequenceGenerator(name = "tag_id_generator", sequenceName = "tag_seq_gen", allocationSize = 1)
	@Column(name = "tag_id")
	private Long tagId;

	@Basic
	@Column(name = "tag", nullable = false)
	private String tag;

	public Long getTagId() {
		return tagId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

}
