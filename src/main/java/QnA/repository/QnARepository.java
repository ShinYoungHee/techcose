package QnA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QnA.entity.QnA;

@Repository
public interface QnARepository extends JpaRepository<QnA,String>{
	public QnA findBypostNum(int postNum);
}
