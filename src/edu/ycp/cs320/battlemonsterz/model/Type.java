package edu.ycp.cs320.battlemonsterz.model;


public enum Type {
GRASS("GRASS"), 
FIRE("FIRE"), 
WATER("WATER");
	


    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }

}