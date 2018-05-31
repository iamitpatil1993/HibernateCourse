package com.example.hibernate.softdelete;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: PostComment
 *
 */
@Loader(namedQuery = "PostComment.findById")
@NamedQuery(
		name = "PostComment.findById",
		query = "SELECT pc FROM PostComment pc WHERE pc.postCommentId = ?1 AND pc.isDeleted = false"
)
@SQLDelete(callable = false, sql = "UPDATE post_comment SET is_deleted = true WHERE post_comment_id = ? AND optimistic_lock_version = ?")
@Where(clause = "is_deleted = false")
@Entity
@Table(name = "post_comment")
public class PostComment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "post_comment_id_gen")
	@SequenceGenerator(name = "post_comment_id_gen", sequenceName = "post_comment_seq_gen")
	@Column(name = "post_comment_id")
	private Long postCommentId;

	@Basic
	@Column(name = "text")
	private String text;

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	public Long getPostCommentId() {
		return postCommentId;
	}

	public void setPostCommentId(Long postCommentId) {
		this.postCommentId = postCommentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postCommentId == null) ? 0 : postCommentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostComment other = (PostComment) obj;
		if (postCommentId == null) {
			if (other.postCommentId != null)
				return false;
		} else if (!postCommentId.equals(other.postCommentId))
			return false;
		return true;
	}

}
