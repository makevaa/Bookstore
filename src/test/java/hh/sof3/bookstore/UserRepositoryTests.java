package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.User;
import hh.sof3.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Autowired
    TestEntityManager entityManager;

    // Test finding user by username
    @Test 
    public void findUserByUsername() {
        User user = new User("MyTestUser", "", "");
        repository.save(user);
        User foundUser = repository.findByUsername("MyTestUser");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("MyTestUser");
    }

    // Test creating a new user
    @Test
    public void createUser() {
        User user = new User("", "", "");
        repository.save(user);
        assertThat(user.getId()).isNotNull();
    }
    
    // Test deleting a user
    @Test
    public void deleteUser() {
        User user = new User("TestUser", "", "");
        entityManager.persist(user);
        repository.delete(user);
	    assertThat(entityManager.find(User.class, user.getId())).isNull();
    }
}