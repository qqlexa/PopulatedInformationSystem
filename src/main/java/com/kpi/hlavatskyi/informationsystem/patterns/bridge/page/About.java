package com.kpi.hlavatskyi.informationsystem.patterns.bridge.page;

import com.kpi.hlavatskyi.informationsystem.patterns.bridge.theme.Theme;

public class About implements WebPage {

    private Theme theme;

    public About() {};

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public Theme getTheme() {
        return theme;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof About;
    }

}
