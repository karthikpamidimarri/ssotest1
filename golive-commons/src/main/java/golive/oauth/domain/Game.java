package golive.oauth.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

/**
 * A Game.
 */
@Entity
@Table(name = "game")
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Game implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Pattern(regexp = "^[A-Za-z0-9\\s]*$")
	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@Column(name = "logo_url")
	private String logoUrl;

	@Column(name = "assets_url")
	private String assetsUrl;

	@Email
	@Column(name = "email")
	private String email;

	@Email
	@Column(name = "help_email")
	private String helpEmail;

	@Column(name = "play_store_id")
	private String playStoreId;

	@Column(name = "app_store_id")
	private String appStoreId;

	@Column(name = "bonus_cycle")
	private Integer bonusCycle;

	@Column(name = "consecutive_DBC")
	private Integer consecutiveDBC;

	// @Column(name= "consecutive_DBC")
	// private Integer conecutiveDBC;
	//
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Game game = (Game) o;

		if (id != null ? !id.equals(game.id) : game.id != null)
			return false;

		return true;
	}

	public String getAppStoreId() {
		return appStoreId;
	}

	public String getAssetsUrl() {
		return assetsUrl;
	}

	public Integer getBonusCycle() {
		return bonusCycle;
	}

	public Integer getConsecutiveDBC() {
		return consecutiveDBC;
	}

	public String getEmail() {
		return email;
	}

	public String getHelpEmail() {
		return helpEmail;
	}

	public Long getId() {
		return id;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public String getName() {
		return name;
	}

	public String getPlayStoreId() {
		return playStoreId;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public int hashCode() {
		// return (int) (id ^ (id >>> 32));
		return playStoreId.hashCode();
	}

	public void setAppStoreId(String appStoreId) {
		this.appStoreId = appStoreId;
	}

	public void setAssetsUrl(String assetsUrl) {
		this.assetsUrl = assetsUrl;
	}

	public void setBonusCycle(Integer bonusCycle) {
		this.bonusCycle = bonusCycle;
	}

	public void setConsecutiveDBC(Integer consecutiveDBC) {
		this.consecutiveDBC = consecutiveDBC;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHelpEmail(String helpEmail) {
		this.helpEmail = helpEmail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayStoreId(String playStoreId) {
		this.playStoreId = playStoreId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Game{" + "id=" + id + ", name='" + name + "'" + ", url='" + url
				+ "'" + ", logoUrl='" + logoUrl + "'" + ", assetsUrl='"
				+ assetsUrl + "'" + ", email='" + email + "'" + ", helpEmail='"
				+ helpEmail + "'" + ", playStoreId='" + playStoreId + "'"
				+ ", appStoreId='" + appStoreId + "'" + ", bonusCycle='"
				+ bonusCycle + "'" + '}';
	}
}
