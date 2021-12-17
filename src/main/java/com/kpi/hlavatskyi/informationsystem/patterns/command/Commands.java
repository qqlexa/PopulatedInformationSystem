package com.kpi.hlavatskyi.informationsystem.patterns.command;

public enum Commands {
    HOME("/app/home", new HomeCommand()),
    ADMIN("/app/admin", new AdminCommand());

    Command command;

    private final String path;

    Commands(String path, Command command) {
        this.path = path;
        this.command = command;
    }

    public String getPath() {
        return path;
    }

    public Command getCommand() {
        return command;
    }

}
