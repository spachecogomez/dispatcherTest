package com.almundo.test.model;

/**
 * This enum lists the actor's type within the system.
 *
 * @author Sebastian Pacheco
 * @version 1.0
 *
 * Created by sebastianpacheco on 14/01/18.
 */
public enum ActorType {

    OPERATOR("operator"),
    SUPERVISOR("supervisor"),
    DIRECTOR("director");

    private String value;

    private ActorType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
