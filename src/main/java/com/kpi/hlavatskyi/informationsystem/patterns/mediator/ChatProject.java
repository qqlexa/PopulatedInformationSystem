package com.kpi.hlavatskyi.informationsystem.patterns.mediator;

public class ChatProject implements ChatProjectMediator {

    @Override
    public void showMessage(User user, String message) {
        String sender = user.getName();
        System.out.println("[" + sender + "]: " + message);
    }

}
