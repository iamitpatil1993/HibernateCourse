package com.example.hibernate.softdelete;

import com.example.hibernate.softdelete.BaseEntity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Loader(namedQuery = "Post.findById")
@NamedQuery(
		name = "Post.findById",
		query = "SELECT p FROM Post p WHERE p.postId = ?1 AND p.isDeleted = false"
)
@SQLDelete(callable = false, sql = "UPDATE post SET is_deleted = true WHERE post_id = ? AND optimistic_lock_version = ?")
@Where(clause = "is_deleted = false")
@Entity
@Table(name = "post")
public class Post extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "post_id_gen")
	@SequenceGenerator(name = "post_id_gen", sequenceName = "post_seq_gen")
	@Column(name = "post_id")
	private Long postId;

	@Basic
	@Column(name = "title")
	private String title;

	@Basic
	@Column(name = "text")
	private String text;

	@OneToMany(mappedBy = "post")
	// @Where(clause = "is_deleted = false") No ned to add this here since where clasue on PostComment will add default filter to PostComment query
	private Set<PostComment> comments = new HashSet<>();
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "post_detail_id")
	@Where(clause = "is_deleted = false")// This has no effect on single value associations, only works for collection associations
	private PostDetail postDetail;

	public PostDetail getPostDetail() {
		return postDetail;
	}

	public void setPostDetail(PostDetail postDetail) {
		this.postDetail = postDetail;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void addPostComment(PostComment comment) {
		comment.setPost(this);
		this.comments.add(comment);
	}
	
	public void removePostComment(PostComment comment) {
		this.comments.remove(comment);
		comment.setPost(null);
	}
	
	public void addPostDetail(PostDetail detail) {
		detail.setPost(this);
		this.setPostDetail(detail);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<PostComment> getComments() {
		return comments;
	}
	
	
}
