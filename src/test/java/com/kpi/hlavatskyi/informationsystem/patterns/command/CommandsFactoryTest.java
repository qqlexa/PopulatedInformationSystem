package com.kpi.hlavatskyi.informationsystem.patterns.command;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandsFactoryTest {

    HttpServletRequest request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        request = mock(HttpServletRequest.class);
    }

    @Test
    public void getCommand_correctAdminCommand() {
        when(request.getRequestURI()).thenReturn("example.com/app/admin");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        Command command = CommandsFactory.getCommand(request);
        assertTrue(command instanceof AdminCommand);
    }

    @Test
    public void getCommand_correctHomeCommand() {
        when(request.getRequestURI()).thenReturn("example.com/app/home");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        Command command = CommandsFactory.getCommand(request);
        assertTrue(command instanceof HomeCommand);
    }

    @Test(expected = NotFoundCommandException.class)
    public void getCommand_wrongRequest_exception() {
        when(request.getRequestURI()).thenReturn("example.com/wrong-url");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        Command command = CommandsFactory.getCommand(request);
        assertTrue(command instanceof AdminCommand);
    }

}