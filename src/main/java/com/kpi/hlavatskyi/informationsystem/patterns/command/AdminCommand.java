package com.kpi.hlavatskyi.informationsystem.patterns.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page("/WEB-INF/jsp/admin/admin.jsp", false);
    }

}