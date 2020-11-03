package account.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import account.entity.Account;
import account.entity.AccountDao;

public class AccountServiceClient {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	private static AccountDao mDao;
	
	// 생성자 함수 안에 넣기
	public AccountServiceClient() {
		
		emf = Persistence.createEntityManagerFactory("SAproject");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		
		if (mDao == null) {
			mDao = new AccountDao();
		}
	}
	
	public void select() {
		try {
			tx.begin();
			List<Account> account = null;

			String jpql = "SELECT m from Account m";
			account = em.createQuery(jpql, Account.class).getResultList();

			System.out.println("-------------------------------------");
			for (Account act : account) {
				System.out.println(act.getId()+" "+act.getName());
			}
			System.out.println("-------------------------------------");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		emf.close();
		
	}
}
