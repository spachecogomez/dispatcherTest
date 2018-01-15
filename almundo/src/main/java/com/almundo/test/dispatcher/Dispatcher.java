package com.almundo.test.dispatcher;

import com.almundo.test.model.Actor;
import com.almundo.test.model.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public Actor dispatchCall(Call call){
        if(!getOperators().isEmpty()){
            return getOperators().poll();
        }else if(getSupervisors().isEmpty()){
            return getSupervisors().poll();
        }
        return getDirectors().poll();
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
