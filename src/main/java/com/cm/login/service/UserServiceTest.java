package com.cm.login.service;

import com.cm.login.model.User;
import com.cm.login.repository.RoleRepository;
import com.cm.login.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {

        userServiceUnderTest = new UserService(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);

        user = User.builder()
                .id(1)
                .name("Mike")
                .lastName("Jones")
                .email("mike.jones@test.com")
                .build();

        Mockito.when(mockUserRepository.save(Mockito.any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(Mockito.anyString())).thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        final String email = "mike.jones@test.com";

        final User result = userServiceUnderTest.findUserByEmail(email);

        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        final String email = "mike.jones@test.com";

        User result = userServiceUnderTest.saveUser(User.builder().build());

        assertEquals(email, result.getEmail());
    }
}
