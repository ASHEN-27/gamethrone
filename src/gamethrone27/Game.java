package gamethrone27;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int gameid;
	private String gamename;
	private String gamecompany;
	private String gameplatform;
	private String gameyear;
	private String gamefeedback;
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public String getGamecompany() {
		return gamecompany;
	}
	public void setGamecompany(String gamecompany) {
		this.gamecompany = gamecompany;
	}
	public String getGameplatform() {
		return gameplatform;
	}
	public void setGameplatform(String gameplatform) {
		this.gameplatform = gameplatform;
	}
	public String getGameyear() {
		return gameyear;
	}
	public void setGameyear(String gameyear) {
		this.gameyear = gameyear;
	}
	public String getGamefeedback() {
		return gamefeedback;
	}
	public void setGamefeedback(String gamefeedback) {
		this.gamefeedback = gamefeedback;
	}
	
	
	

}
