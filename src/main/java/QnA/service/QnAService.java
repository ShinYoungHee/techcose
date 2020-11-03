package QnA.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import QnA.entity.QnA;
import QnA.repository.QnARepository;

@Service
public class QnAService {
	@Autowired
	private QnARepository qr;
		
	public List<QnA> getQnAList() {
		return qr.findAll();
	}
	
	public QnA getBoard(int num) {
		QnA qna=qr.findBypostNum(num);
		return qna;
	}
	
	public void enrolledQnA(QnA qna,HttpServletRequest req) {
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
		String time=format.format(date);
		try {
			qna.setEnrolledDate(format.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		String writer=(String) session.getAttribute("sessionID");
		qna.setWriter(writer);
		qr.save(qna);
	}
}
