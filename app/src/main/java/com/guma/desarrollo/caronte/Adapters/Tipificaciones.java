package com.guma.desarrollo.caronte.Adapters;

/**
 * Created by maryan.espinoza on 13/01/2017.
 */

public class Tipificaciones {
    String code = null;
    String name = null;
    boolean selected = false;

    public Tipificaciones(String code, String name, boolean selected) {
        super();
        this.code = code;
        this.name = name;
        this.selected = selected;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
