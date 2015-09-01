package golive.oauth.domain;

import golive.oauth.domain.User;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * A Player.
 */
@Entity
@Table(name = "player",uniqueConstraints=@UniqueConstraint(columnNames={"user_id","game_id"}))
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Player implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Pattern(regexp = "^[A-Za-z0-9_-]*$")
    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "referral_id")
    private String referral_id;

    @Column(name = "game_version")
    private Integer game_version;
    
    @Column(name = "user_id")
    private Long userId;

//    @NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id",insertable=false,updatable=false)
    private User user;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="device_id")
    private Device device;

	//	@NotNull
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="game_id")
    private Game game;

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Player player = (Player) o;

        if (id != null ? !id.equals(player.id) : player.id != null) return false;

        return true;
    }

	public Device getDevice() {
		return device;
	}

	public Game getGame() {
        return game;
    }

	
//	@Column(name = "game_id")
//    private Long gameId;
	
	
public Integer getGame_version() {
        return game_version;
    }
    
	public Long getId() {
        return id;
    }

    public String getImage_url() {
        return image_url;
    }

//	public Long getGameId() {
//		return gameId;
//	}
//
//	public void setGameId(Long gameId) {
//		this.gameId = gameId;
//	}

	public Integer getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getReferral_id() {
        return referral_id;
    }

    public User getUser() {
        return user;
    }

    public Long getUserId() {
		return userId;
	}

    public void setDevice(Device device) {
		this.device = device;
	}

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGame_version(Integer game_version) {
        this.game_version = game_version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReferral_id(String referral_id) {
        this.referral_id = referral_id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public void setUserId(Long userId) {
		this.userId = userId;
	}

//    @Override
//    public int hashCode() {
//        return (int) (id ^ (id >>> 32));
//    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + "'" +
                ", level='" + level + "'" +
                ", image_url='" + image_url + "'" +
                ", referral_id='" + referral_id + "'" +
                ", game_version='" + game_version + "'" +
                '}';
    }
}