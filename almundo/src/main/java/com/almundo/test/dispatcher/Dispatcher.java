package com.almundo.test.dispatcher;

import com.almundo.test.model.Actor;
import com.almundo.test.model.ActorType;
import com.almundo.test.model.Call;
import com.almundo.test.model.Status;
import com.almundo.test.model.exception.NoAgentAvailable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * This class is in charge of dispatch the incoming user calls to the Actors available.
 *
 * @author Sebastian Pacheco
 * @version 1.0
 *
 * Created by sebastianpacheco on 14/01/18.
 */
public class Dispatcher {

    private Logger log = LoggerFactory.getLogger(Dispatcher.class);

    private ArrayBlockingQueue<Actor> operators;

    private ArrayBlockingQueue<Actor> supervisors;

    private ArrayBlockingQueue<Actor> directors;

    public Dispatcher(ArrayBlockingQueue<Actor> operators, ArrayBlockingQueue<Actor> supervisors, ArrayBlockingQueue<Actor> directors){
        this.setOperators(operators);
        this.setSupervisors(supervisors);
        this.setDirectors(directors);
    }

    public Status getStatus(){
        Status status = new Status();
        status.setAvailableOperators(this.operators.size());
        status.setAvailableSupervisors(this.supervisors.size());
        status.setAvailableDirectors(this.directors.size());
        return  status;
    }

    public Actor dispatchCall(Call call) throws NoAgentAvailable {
        Actor actor;
        synchronized (this){
            call.setCallStartDate(new Date());
            if(!getOperators().isEmpty()){
                actor = getOperators().remove();
            }else if(!getSupervisors().isEmpty()){
                actor = getSupervisors().poll();
            }else if(!getDirectors().isEmpty()){
                actor = getDirectors().poll();
            }else{
                throw new NoAgentAvailable();
            }
            call.setAttendant(actor);
            actor.getCalls().add(call);
        }

        return actor;
    }

    public void enqueueActor(Actor actor) {
        log.debug(String.format("Enqueueing and actor of type %s",actor.getActorType().getValue()));
        switch (actor.getActorType()){
            case OPERATOR:
                getOperators().add(actor);
                break;
            case DIRECTOR:
                getDirectors().add(actor);
                break;
            case SUPERVISOR:
                getSupervisors().add(actor);
                break;

        }
    }


    public ArrayBlockingQueue<Actor> getOperators() {
        return operators;
    }

    public void setOperators(ArrayBlockingQueue<Actor> operators) {
        this.operators = operators;
    }

    public ArrayBlockingQueue<Actor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(ArrayBlockingQueue<Actor> supervisors) {
        this.supervisors = supervisors;
    }

    public ArrayBlockingQueue<Actor> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayBlockingQueue<Actor> directors) {
        this.directors = directors;
    }
}
