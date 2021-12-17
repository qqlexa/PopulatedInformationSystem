package com.kpi.hlavatskyi.informationsystem.patterns.mediator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ChatProjectTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void showMessage() {
        ChatProjectMediator mediator = new ChatProject();

        User firstUser = new User("Anna", mediator);
        User secondUser = new User("Max", mediator);

        String messageByFirstUser = "Can I help you?";
        String messageBySecondUser = "Yes, of course!";

        String expected = "[" + firstUser.getName() + "]: " + messageByFirstUser + System.lineSeparator() +
                "[" + secondUser.getName() + "]: " + messageBySecondUser;

        firstUser.sendMessage("Can I help you?");
        secondUser.sendMessage("Yes, of course!");

        assertEquals(expected, outContent.toString().trim());
    }

}