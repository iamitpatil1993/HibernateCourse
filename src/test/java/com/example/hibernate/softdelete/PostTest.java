package com.example.hibernate.softdelete;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostTest extends BaseTest {

	private static Long postId = null;
	private static Long postCommentId = null;

	@Test
	public void aCreatePostTest() {
		Post post = new Post();
		post.setText("Test post added");
		post.setTitle("Soft Delete Demo");
	
		PostDetail postDetail = new PostDetail();
		postDetail.setCreatedByUserName("amit");
		post.addPostDetail(postDetail);
		
		em.persist(post);
		
		
		
		assertNotNull(post.getPostId());
		postId = post.getPostId();
	}
	
	@Test
	public void abFindPostTest() {
		Post postComment = em.find(Post.class, postId);
		assertNotNull(postComment);
	}
		
	@Test
	public void bCreatePostCommentTest() {
		PostComment postComment = new PostComment();
		postComment.setText("Test post added");
		postComment.setPost(em.getReference(Post.class, postId));
		em.persist(postComment);
		
		 postComment = new PostComment();
			postComment.setText("Test post added");
			postComment.setPost(em.getReference(Post.class, postId));
			em.persist(postComment);
		postCommentId = postComment.getPostCommentId();
	}
	
	@Test
	public void cFindPostCommentTest() {
		PostComment postComment = em.find(PostComment.class, postCommentId);
		assertNotNull(postComment);
	}
	
	@Test
	public void cRemovePostCommentTest() {
		em.remove(em.getReference(PostComment.class, postCommentId));
	}
	
	@Test
	public void cRemoveePostTest() {
		em.remove(em.getReference(Post.class, postId));
	}
}
