package com.kpi.hlavatskyi.informationsystem.patterns.bridge.theme;

public class DarkTheme implements Theme{

    @Override
    public String getColor() {
        return "Dark Theme";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof DarkTheme;
    }

}
