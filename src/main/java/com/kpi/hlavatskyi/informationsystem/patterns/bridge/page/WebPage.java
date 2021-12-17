package com.kpi.hlavatskyi.informationsystem.patterns.bridge.page;

import com.kpi.hlavatskyi.informationsystem.patterns.bridge.theme.Theme;

public interface WebPage {

    void setTheme(Theme theme);

    Theme getTheme();

}
