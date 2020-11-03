package QnA.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
@Table(name="Comment")
public class Comment {
	@Id
	private int commentNum;
	private String writer;
	private String comment;
	private Date enrollDate;
	private int postingNum;
	
	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public int getPostingNum() {
		return postingNum;
	}


	public void setPostingNum(int postingNum) {
		this.postingNum = postingNum;
	}


	public int getCommentNum() {
		return commentNum;
	}


	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	
	public Comment() {
		super();
	}
   
}
