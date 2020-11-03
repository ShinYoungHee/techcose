package QnA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import QnA.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{
	public List<Comment> findByPostingNum(int postingNum);
}
