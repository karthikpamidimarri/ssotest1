package golive.oauth.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
* A Device.
*/
@Entity
@Table(name = "device")
public class Device implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	@Size(min = 12, max = 512)
	@Column(name = "identifier",length = 512, nullable = false, unique = true)
	private String identifier;

   @NotNull
   @Pattern(regexp = "^[A-Za-z0-9]*$")
   @Size(min = 12, max = 1024)
   @Column(name = "device_key", length = 1024, nullable = false)
   private String deviceKey;
   
   @JsonIgnore
   @NotNull
   @Size(min = 6, max = 160)
   @Column(name = "passphrase", length = 160)
   private String passphrase;
   
//	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	@JoinTable(name = "device_registeration", joinColumns = { @JoinColumn(name = "device_id") }, inverseJoinColumns = { @JoinColumn(name = "game_id") })
//	private Set<Game> games = new HashSet<Game>(); 

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }
   
   public String getIdentifier() {
   	return identifier;
   }
   
   public void setIdentifier(String identifier){
   	this.identifier = identifier;
   }
   
   public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String devicekey) {
		this.deviceKey = devicekey;
	}

	public String getPassphrase() {
       return passphrase;
   }

   public void setPassphrase(String passphrase) {
       this.passphrase = passphrase;
   }
  
   @Override
   public boolean equals(Object o) {
       if (this == o) {
           return true;
       }
       if (o == null || getClass() != o.getClass()) {
           return false;
       }

       Device device = (Device) o;

       if (id != null ? !id.equals(device.id) : device.id != null) return false;

       return true;
   }

   @Override
   public int hashCode() {
       //return (int) (id ^ (id >>> 32));
   	return identifier.hashCode();
   }

   @Override
   public String toString() {
       return "Device{" +
               "id=" + id +
               ", deviceId='" + deviceKey + "'" +
               ", passphrase='" + passphrase + "'" +
               '}';
   }
   
}