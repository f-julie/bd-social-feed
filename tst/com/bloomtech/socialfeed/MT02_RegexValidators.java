package com.bloomtech.socialfeed;

import com.bloomtech.socialfeed.exceptions.EmailValidationException;
import com.bloomtech.socialfeed.exceptions.UserValidationException;
import com.bloomtech.socialfeed.models.User;
import com.bloomtech.socialfeed.repositories.UserRepository;
import com.bloomtech.socialfeed.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


public class MT02_RegexValidators {
    @Mock
    UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
        SeedData.run();
    }

    @Test
    public void createUser_InvalidUsername_ExpectException() {
        User user = new User();
        user.setUsername("badusername");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidUsername2_ExpectException() {
        User user = new User();
        user.setUsername("Baduser name");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidUsername3_ExpectException() {
        User user = new User();
        user.setUsername("badUsername");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidUsername4_ExpectException() {
        User user = new User();
        user.setUsername("Bad");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidPassword_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("badpassword");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidPassword2_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("Badpassword");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidPassword3_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("Badp2");

        assertThrows(UserValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidEmail_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("GoodPass123");
        user.setEmail("bademail");

        assertThrows(EmailValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidEmail2_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("GoodPass123");
        user.setEmail("bade@mail");

        assertThrows(EmailValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createUser_InvalidEmail3_ExpectException() {
        User user = new User();
        user.setUsername("Fineusername");
        user.setPassword("GoodPass123");
        user.setEmail("bade@123.");

        assertThrows(EmailValidationException.class, ()->{
            userService.save(user);
        });
    }

    @Test
    public void createValidUser_expectCreateSuccessfully() {
        User user = new User();
        user.setUsername("Fineusername123");
        user.setPassword("Good!@#$%^&*Pass123");
        user.setEmail("good_email@email.com");

        userService.save(user);
        Mockito.verify(userRepository).save(any(User.class));
    }
}
