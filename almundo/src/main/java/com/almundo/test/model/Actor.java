package com.almundo.test.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class represents the actors within the system.
 *
 * @author Sebastian Pacheco
 * @version 1.0
 *
 * Created by sebastianpacheco on 14/01/18.
 */
public class Actor {

    private String name;

    private ActorType actorType;

    private List<Call> calls;

    public Actor(){
        this.calls = new ArrayList<Call>();
    }

    public Actor(String name){
        this.name = name;
        this.calls = new ArrayList<Call>();
    }

    public Actor(String name, ActorType actorType){
        this.name = name;
        this.actorType = actorType;
        this.calls = new ArrayList<Call>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActorType getActorType() {
        return actorType;
    }

    public void setActorType(ActorType actorType) {
        this.actorType = actorType;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    @Override
    public String toString(){
        return String.format("[ActorType : %s | Name: %s]", actorType.getValue(), name);
    }
}
