package gamethrone27;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class GameDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Game> getallGames() {
		Query query = em.createQuery("SELECT g FROM Game g");
		return query.getResultList();
//		
//		return null;
	}

	public Game getonegame(int id) {
		
		return em.find(Game.class, id);
	}

	public void add(Game game) {
		em.persist(game);
		
	}

	public void update(Game game) {
		em.merge(game);
		
	}

	public void delete(int id) {
		em.remove(getonegame(id));
		
	}

	public List<Game> getGameByName(String n) {
		return em
				.createQuery("select g from Game g where g.gamename like :gname")
				.setParameter("gname", n)
				.getResultList();
	}

	public List<Game> getGameByCompany(String c) {
		return em
				.createQuery("select g from Game g where g.gamecompany like :gcompany")
				.setParameter("gcompany", c)
				.getResultList();
	}

}
