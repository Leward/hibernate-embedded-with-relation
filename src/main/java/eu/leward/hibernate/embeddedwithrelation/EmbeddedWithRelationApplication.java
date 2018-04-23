package eu.leward.hibernate.embeddedwithrelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EmbeddedWithRelationApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedWithRelationApplication.class, args);
	}

	@PostConstruct
	public void init() {
		PlayerProfile playerProfile = new PlayerProfile();
		playerProfile.setNickname("toto");
		playerProfile.addRole(PlayerRole.FLEX);
		playerProfile.addRole(PlayerRole.SUPPORT);

		User user = new User();
		user.setEmail("test@test.com");
		user.setPlayerProfile(playerProfile);

		userRepository.save(user);
	}
}
