package com.mbaczewski.main;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserServiceTest {
    
    @Test
    public void shouldReturnAllUsers() throws SQLException{
        // given
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(connectionMock.prepareStatement("*")).thenReturn(preparedStatementMock);
        UserService userService = new UserService(connectionMock);
        // when
        ResultSet resultSet = userService.queryUsers("*");
        // then
        assertTrue(resultSet.next());
        assertEquals("Michal", resultSet.getString(0));
        assertFalse(resultSet.next());
    }

}