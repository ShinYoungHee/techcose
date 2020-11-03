package QnA.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QnA.entity.QnA;
import QnA.service.CommentService;
import QnA.service.QnAService;

@Controller
public class QnAController {	
	@Autowired
	QnAService qs;
	@Autowired
	CommentService cs;
	// 질문답변 메인 화면
	@RequestMapping("/BoardList")
	public String intro(Model model) {
		System.out.println("질문 메인 컨트롤러 실행됨");
		List<QnA> QnAList=qs.getQnAList();
		model.addAttribute("QnAList", QnAList);
		return "QnA/BoardList";
	}
	

	@RequestMapping("/findBoard")
	public String get(Model model,@RequestParam("postNum") int postNum) {
		System.out.println("글  컨트롤러 실행됨");
		model.addAttribute("comment",cs.allComment(postNum));
		model.addAttribute("QnA",qs.getBoard(postNum));
		
		return "QnA/getBoard";
	}
	

	@RequestMapping("/insertBoard")
	public String insert(Model model) {
		System.out.println("글 등록 컨트롤러 실행됨");
		return "QnA/insertBoard";
	}
	
	@RequestMapping("/enroll")
	public String enroll(Model model,QnA qna,HttpServletRequest req) {
		System.out.println("글 등록 ");
		qs.enrolledQnA(qna,req);
		return "redirect:BoardList";
	}
	

	@RequestMapping("/updateBoard")
	public String update(Model model) {
		System.out.println("글 수정 컨트롤러 실행됨");
		return "QnA/updateBoard";
	}
}
