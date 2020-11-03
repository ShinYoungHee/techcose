package account.repository;
import org.springframework.stereotype.Repository;

import account.entity.Account;


import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
	public Account findByid(String id);
	public Account findBybusinessNum(String businessNum);
	public Account findByphone(String phone);
}
