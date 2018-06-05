package com.example.hibernate.softdelete;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: PostDetail
 *
 */
@Entity
@Table(name = "post_detail")
//@Loader(namedQuery = "PostDetail.findById")
@NamedQuery(
		name = "PostDetail.findById",
		query = "SELECT p FROM PostDetail p WHERE p.postId = ?1 AND p.isDeleted = false"
)
@SQLDelete(callable = false, sql = "UPDATE post_detail SET is_deleted = true WHERE post_id = ? AND optimistic_lock_version = ?")
@Where(clause = "is_deleted = false")
public class PostDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	private Long postId;

	@OneToOne(mappedBy = "postDetail")
	@MapsId
	private Post post;

	@Basic
	@Column(name = "created_by_user")
	private String createdByUserName;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getCreatedByUserName() {
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}

}
