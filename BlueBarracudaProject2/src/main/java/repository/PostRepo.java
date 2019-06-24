package repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Post;

@Repository("postRepo")
@Transactional
public class PostRepo {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sesFact;
	
	public PostRepo() {	
	}
	
	@Autowired
	public PostRepo(SessionFactory sesFact) {
		this.sesFact = sesFact;
	}
	
	public void insert(Post post) {
		sesFact.getCurrentSession().save(post);
	}
	
	public void update(Post post) {
		sesFact.getCurrentSession().update(post);
	}
	
	public void delete(Post post) {
		sesFact.getCurrentSession().delete(post);
	}
	
	public Post selectByInt(int id) {
		return sesFact.getCurrentSession().get(Post.class,id);
	}
	
	public List<Post> SelectAll(){
		return sesFact.getCurrentSession().createQuery("from Post", Post.class).list(); 
				
	}
}
