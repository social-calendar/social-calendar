package com.socialCalendar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.socialCalendar.dao.CommentDao;
import com.socialCalendar.pojo.Comment;
import com.socialCalendar.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDao commentDao;
	
	@Override
	public int updateComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	@Override
	public int deleteComment(Integer commentID) {
		return commentDao.deleteComment(commentID);
	}

	@Override
	public Comment findCommentByCommentId(Integer commentID) {
		return commentDao.findCommentByCommentId(commentID);
	}

	@Override
	public List<Comment> findCommentByUserId(Integer commentUserId) {
		return commentDao.findCommentByUserId(commentUserId);
	}

	@Override
	public List<Comment> findCommentByContent(String commentContent) {
		return commentDao.findCommentByContent(commentContent);
	}

	@Override
	public List<Comment> findCommentByEventId(Integer commentEventId) {
		return commentDao.findCommentByEventId(commentEventId);
	}
}
