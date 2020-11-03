package QnA.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import QnA.entity.Comment;
import QnA.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository cr;
	
	public void enrolled_comment(int postingNum,Comment comment,HttpServletRequest req) {
		comment.setPostingNum(postingNum);
		HttpSession session = req.getSession();
		String writer=(String) session.getAttribute("sessionID");
		comment.setWriter(writer);
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		String time=format.format(date);
		try {
			comment.setEnrollDate(format.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(comment.getComment());
		cr.save(comment);
	}
	
	public List<Comment> allComment(int postingNum){
		return cr.findByPostingNum(postingNum);
	}
	
}
