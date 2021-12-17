package com.kpi.hlavatskyi.informationsystem.patterns.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String name;

    private ChatProjectMediator chatMediator;

    public void sendMessage(String message) {
        this.chatMediator.showMessage(this, message);
    }

}
