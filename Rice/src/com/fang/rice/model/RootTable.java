package com.fang.rice.model;
import java.util.List;

public class RootTable {

    private List<Type> types;

    public RootTable(List<Type> tableNames) {
        this.types = tableNames;
    }


    public RootTable() {
    }


    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
