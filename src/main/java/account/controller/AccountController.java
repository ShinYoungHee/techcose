package account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import account.entity.Account;
import account.service.AccountService;
import account.service.AccountServiceClient;

/*
 * account 관련 파일을 실행시키기 위한 컨트롤러
 * @Controller는 컨트롤러라는 뜻이고,
 * @RequestMapping("/jsp이름")은 해당하는 jsp이름으로 요청이 들어오면 실행한다는 뜻이다. 매핑 문제가 생긴 거면 여기서 발생!!
 * 이떄, return "폴더이름/jsp이름" 으로 반환해줘야 한다.
 * 제대로 작동하는지 확인하기 위해 System.out.println 으로 콘솔창에 표시. 이 라인은 삭제해도 됨.
 * 
 *  */

@Controller
public class AccountController {
	
	@Autowired
	AccountService act;
	
	// 메인 화면, 로그인 화면
	@RequestMapping(value = {"/", "/Login"})
	public String login(Model model) {
		System.out.println("Login 컨트롤러 실행됨");
		
		// 실행
		AccountServiceClient as = new AccountServiceClient();
		as.select();
		
		return "account/login";
	}
	
	// 회원가입 중간 페이지
	@RequestMapping("/select")
	public String registPage(Model model) {
		System.out.println("중간 회원가입 컨트롤러 실행됨");
		return "account/select";
	}
	
	// 농부 회원가입 페이지
	@RequestMapping("/farmerRegist")
	public String farmer(Model model) {
		System.out.println("농부 회원가입 컨트롤러 실행됨");
		return "account/farmerRegist";
	}
	
	// 일반 회원가입 페이지
	@RequestMapping("/standardRegist")
	public String standard(Model model) {
		System.out.println("일반 회원가입 컨트롤러 실행됨");
		return "account/standardRegist";
	}
	
	// 농부 회원가입 서비스 실행
	@RequestMapping("regist")
	public String regist(Model model,Account account) {
		System.out.println("회원가입 서비스 실행");
		act.regist(account);
		return "account/login";
	}
		
	// 아이디 찾기 페이지
	@RequestMapping("/id_found")
	public String idFound(Model model) {
		System.out.println("아이디 찾기 컨트롤러 실행됨");
		return "account/id_found";
	}
	
	// 비밀번호 찾기 페이지
	@RequestMapping("/pw_found")
	public String pwFound(Model model) {
		System.out.println("비밀번호 찾기 컨트롤러 실행됨");
		return "account/pw_found";
	}
	
	//비밀번호 찾기 서비스 실행
	@RequestMapping("/pwd_service")
	public String pwdFound(Model model,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("비밀번호 찾기 서비스 실행됨");
		Account account=new Account();
		account.setId(request.getParameter("id"));
		account.setName(request.getParameter("name"));
		account.setEmail(request.getParameter("email"));
		
		model.addAttribute("pw",act.findPwd(account));
		return "account/pwd_result";
	}
	 @RequestMapping("idCheck")
	 public @ResponseBody String id_check(HttpServletRequest request) {
		 System.out.println("아이디 중복 체크");
	     System.out.println(request.getParameter("id"));
	     String str = act.idCheck(request.getParameter("id"));
	     System.out.print(str);
	     return str;
	 }
	 @RequestMapping("bsnCheck")
	 public @ResponseBody String bsn_check(HttpServletRequest request) {
		 System.out.println("bsn 중복 체크");
		 String str=act.bsn_Check(request.getParameter("businessNum"));
		 System.out.println(str);
		 return str;
	 }
	 
	 @RequestMapping("phoneCheck")
	 public @ResponseBody String phone_check(HttpServletRequest request) {
		 System.out.println("폰번호 중복 체크");
		 String str=act.phone_Check(request.getParameter("phone"));
		 System.out.println(str);
		 return str;
	 }
	 
	// 로그인 후, 메인 페이지
	@RequestMapping("/introPageDesign")
	public String intro(Model model) {
		System.out.println("메인 페이지 컨트롤러 실행됨");
		return "account/introPageDesign";
	}
}
