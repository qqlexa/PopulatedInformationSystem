package com.kpi.hlavatskyi.informationsystem.patterns.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {

    Page execute(HttpServletRequest request, HttpServletResponse response);

}
