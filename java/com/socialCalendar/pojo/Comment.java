package com.socialCalendar.pojo;

public class Comment {
	private Integer commentID;	//评论ID
	private Integer commentEventId;//评论时间ID
	private Integer commentUserId;	//评论用户ID
	private String  commentTime;//评论时间
	private String  commentContent;//评论内容
	
	private User commentUser;//评论用户详细信息
	
	public Comment() {
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public Integer getCommentEventId() {
		return commentEventId;
	}

	public void setCommentEventId(Integer commentEventId) {
		this.commentEventId = commentEventId;
	}

	public Integer getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}

	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", commentEventId="
				+ commentEventId + ", commentUserId=" + commentUserId
				+ ", commentTime=" + commentTime + ", commentContent="
				+ commentContent + ", commentUser=" + commentUser + "]";
	}

	public Comment(Integer commentID, Integer commentEventId,
			Integer commentUserId, String commentTime, String commentContent,
			User commentUser) {
		super();
		this.commentID = commentID;
		this.commentEventId = commentEventId;
		this.commentUserId = commentUserId;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
		this.commentUser = commentUser;
	}
	
}
