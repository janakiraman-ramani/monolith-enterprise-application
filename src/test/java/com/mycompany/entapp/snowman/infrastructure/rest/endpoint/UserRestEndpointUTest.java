/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.User;
import com.mycompany.entapp.snowman.domain.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UserRestEndpointUTest {

    @Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserRestEndpoint classInTest = new UserRestEndpoint();


    @Test
    public void getUserWithUserIdShouldReturnTheUser() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("Username");
        user.setPassword("Password");
        user.setFirstname("Firstname");
        user.setLastname("Lastname");
        user.setEmail("Email");

        Mockito.when(userService.findUser("1")).thenReturn(user);

        ResponseEntity<User> responseEntity = classInTest.getUser("1");

        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
        assertEquals(user, responseEntity.getBody());
    }
}