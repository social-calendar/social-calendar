package com.socialCalendar.service;

import java.util.List;

import com.socialCalendar.pojo.Comment;

public interface CommentService {
	/**
	 * 修改评论
	 * 
	 * @param comment
	 * @return影响的记录数
	 */
	public int updateComment(Comment comment);

	/**
	 * 添加评论
	 * 
	 * @param comment
	 * @return影响的记录数
	 */
	public int addComment(Comment comment);

	/**
	 * 删除评论
	 * 
	 * @param id
	 * @return
	 */
	public int deleteComment(Integer commentID);

	/**
	 * 根据Comment_id查询评论
	 * 
	 * @param
	 * @return 评论
	 */
	public Comment findCommentByCommentId(Integer commentID);

	/**
	 * 根据user_id查询评论
	 * 
	 * @param
	 * @return 评论
	 */
	public List<Comment> findCommentByUserId(Integer commentUserId);

	/**
	 * 根据根据comment_Content查询评论
	 * 
	 * @param (模糊查询)
	 * @return 评论
	 */
	public List<Comment> findCommentByContent(String commentContent);

	/**
	 * 根据comment_event_id查询评论
	 * 
	 * @param
	 * @return 评论
	 */
	public List<Comment> findCommentByEventId(Integer commentEventId);
}
