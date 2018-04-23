package eu.leward.hibernate.embeddedwithrelation;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void test_persist_user() {
        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setNickname("marvin");
        playerProfile.addRole(PlayerRole.FLEX);
        playerProfile.addRole(PlayerRole.SUPPORT);

        User user = new User();
        user.setEmail("marvin@test.com");
        user.setPlayerProfile(playerProfile);
        entityManager.persistAndFlush(user);

        assertThat(userRepository.findByPlayerProfileNickname("marvin")).isPresent();
    }
}