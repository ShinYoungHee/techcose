package QnA.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import QnA.entity.Comment;
import QnA.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	CommentService cs;
	
	@RequestMapping("/enroll_comment")
	public String enroll_comment(Model model,@RequestParam("postNum") int postNum,Comment comment,HttpServletRequest req) {
		System.out.println("댓글 달기 실행");
		cs.enrolled_comment(postNum,comment,req);
		model.addAttribute("postNum",postNum);
		return "redirect:findBoard";
	}
}
