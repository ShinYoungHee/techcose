package account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import account.entity.Account;
import account.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository ar;

	// 아이디 찾기 서비스
	public Account findById(String num) {
		Account account = ar.findByid(num);
		return account;
	}

	// 패스워드 찾기 서비스
	public String findPwd(Account account) {
		Account act = ar.findByid(account.getId());
		try {
			if (account.getEmail().equals(act.getEmail()) && account.getName().equals(act.getName())) {
				return act.getPassword();
			} else {
				System.out.println("정보가 틀립니다.");
				return "정보가 틀립니다.";
			}
		} catch (NullPointerException npe) {
			System.out.println("아이디가 존재하지 않습니다.");
			return "아이디가 존재하지 않습니다.";
		}
	}

	// 회원가입 서비스
	public void regist(Account account) {
		Account act = ar.findByid(account.getId());
		try {
			if (act.getId() != null) {
				System.out.println("중복된 아이디 입니다.");
			}
		} catch (NullPointerException npe) {
			account.setEmail(account.getEmailHead()+"@"+account.getEmailTail());
			//account.setEmail(account.getEmail());
			ar.save(account);
		}

	}

	// 회원가입 아이디 중복 찾기
	public String idCheck(String id) {
		if (ar.findByid(id) == null) {
			System.out.println("not duplicated");
			return "YES";
		} else {
			System.out.println("duplicated");
			return "NO";
		}
	}

	public String bsn_Check(String bsn) {
		if (ar.findBybusinessNum(bsn) == null) {
			System.out.println("not duplicated");
			return "YES";
		} else {
			System.out.println(ar.findBybusinessNum(bsn));
			System.out.println("duplicated");
			return "NO";
		}
	}

	public String phone_Check(String phone) {
		if (ar.findByphone(phone) == null) {
			System.out.println("not duplicated");
			return "YES";
		} else {
			System.out.println(ar.findBybusinessNum(phone));
			System.out.println("duplicated");
			return "NO";
		}
	}
}
