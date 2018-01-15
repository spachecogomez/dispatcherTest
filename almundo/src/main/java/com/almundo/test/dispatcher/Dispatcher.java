package com.almundo.test.dispatcher;

import com.almundo.test.model.Actor;
import com.almundo.test.model.Call;
import com.almundo.test.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Queue;

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

    private Queue<Actor> operators;

    private Queue<Actor> supervisors;

    private Queue<Actor> directors;

    public Dispatcher(Queue<Actor> operators, Queue<Actor> supervisors, Queue<Actor> directors){
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

    public Actor dispatchCall(Call call){
        call.setCallStartDate(new Date());
        Actor actor;
        if(!getOperators().isEmpty()){
            actor = getOperators().poll();
        }else if(getSupervisors().isEmpty()){
            actor = getSupervisors().poll();
        }else {
            actor = getDirectors().poll();
        }
        call.setAttendant(actor);
        actor.getCalls().add(call);
        return actor;
    }


    public Queue<Actor> getOperators() {
        return operators;
    }

    public void setOperators(Queue<Actor> operators) {
        this.operators = operators;
    }

    public Queue<Actor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Queue<Actor> supervisors) {
        this.supervisors = supervisors;
    }

    public Queue<Actor> getDirectors() {
        return directors;
    }

    public void setDirectors(Queue<Actor> directors) {
        this.directors = directors;
    }
}
