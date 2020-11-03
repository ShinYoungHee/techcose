package QnA.entity;


import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: QnA
 *
 */
@Entity
@Table(name="Board")
public class QnA  {

	@Id
	@GeneratedValue
	private int postNum;
	private String title;
	private String content;
	private String attachedFile;
	private String heading;
	private String writer;
	@Temporal(TemporalType.TIMESTAMP)
	private Date enrolledDate;
	
	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}	

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}	

	public Date getEnrolledDate() {
		return enrolledDate;
	}

	public void setEnrolledDate(Date enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

	

	public QnA() {
		super();
	}
   
}
