package repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Comment;
import model.User;

@Repository("userRepo")
@Transactional
public class CommentRepo {
		
		static {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private SessionFactory sesFact;

		public CommentRepo() {
		}
		

		@Autowired
		public CommentRepo(SessionFactory sesFact) {
			super();
			this.sesFact = sesFact;
		}
		
		public void insert(Comment com) {
			
			sesFact.getCurrentSession().save(com);
		}
		
		public void update(Comment com) {
			sesFact.getCurrentSession().update(com);
		}
		
		public void delete(Comment com) {
			sesFact.getCurrentSession().delete(com);;
		}
		
		public Comment selectById(int id) {
			return sesFact.getCurrentSession().get(Comment.class, id);
		}
		
		public List<Comment> selectAll(){
			return sesFact.getCurrentSession().createQuery("from Comment", Comment.class).list();
		}
		


}
