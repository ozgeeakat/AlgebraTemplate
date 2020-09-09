
package com.example.algebratemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityTest {

    @Test
    public void testLogin() {

        Boolean actual = new LoginActivity().login("algebra", "algebra");
        assertTrue(actual);

    }
}

