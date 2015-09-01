package golive.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import golive.oauth.domain.Device;
import golive.oauth.domain.Player;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Device entity.
 */
public interface DeviceRepository extends JpaRepository<Device,Long>{

	
	List<Device> findAllByDeviceKey(String deviceId);
	Optional<Device> findOneByIdentifier(String identifier);
//	List<Device> findAllByPlayer(Player player);
//	Optional<Device> findOness
}
