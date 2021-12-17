package com.kpi.hlavatskyi.informationsystem.patterns.bridge.theme;

public class LightTheme implements Theme {

    @Override
    public String getColor() {
        return "Light Theme";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof LightTheme;
    }

}
