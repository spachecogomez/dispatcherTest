package com.almundo.test.dispatcher;

import com.almundo.test.model.Actor;
import com.almundo.test.model.ActorType;

import java.util.concurrent.ArrayBlockingQueue;

public class DispatcherSingleton {

    private static Dispatcher dispatcher;

    public static Dispatcher getInstance(){
        if(dispatcher == null){
            ArrayBlockingQueue<Actor> supervisors = new ArrayBlockingQueue<Actor>(10);
            Actor supervisor1 = new Actor("supervisor1", ActorType.SUPERVISOR);
            Actor supervisor2 = new Actor("supervisor2", ActorType.SUPERVISOR);
            Actor supervisor3 = new Actor("supervisor3", ActorType.SUPERVISOR);
            Actor supervisor4 = new Actor("supervisor4", ActorType.SUPERVISOR);
            Actor supervisor5 = new Actor("supervisor5", ActorType.SUPERVISOR);
            Actor supervisor6 = new Actor("supervisor6", ActorType.SUPERVISOR);
            Actor supervisor7 = new Actor("supervisor7", ActorType.SUPERVISOR);
            Actor supervisor8 = new Actor("supervisor8", ActorType.SUPERVISOR);
            Actor supervisor9 = new Actor("supervisor9", ActorType.SUPERVISOR);
            Actor supervisor10 = new Actor("supervisor10", ActorType.SUPERVISOR);
            supervisors.add(supervisor1);
            supervisors.add(supervisor2);
            supervisors.add(supervisor3);
            supervisors.add(supervisor4);
            supervisors.add(supervisor5);
            supervisors.add(supervisor6);
            supervisors.add(supervisor7);
            supervisors.add(supervisor8);
            supervisors.add(supervisor9);
            supervisors.add(supervisor10);
            ArrayBlockingQueue<Actor> operators = new ArrayBlockingQueue<Actor>(10);
            Actor operator1 = new Actor("operator1", ActorType.OPERATOR);
            Actor operator2 = new Actor("operator2", ActorType.OPERATOR);
            Actor operator3 = new Actor("operator3", ActorType.OPERATOR);
            Actor operator4 = new Actor("operator4", ActorType.OPERATOR);
            Actor operator5 = new Actor("operator5", ActorType.OPERATOR);
            Actor operator6 = new Actor("operator6", ActorType.OPERATOR);
            Actor operator7 = new Actor("operator7", ActorType.OPERATOR);
            Actor operator8 = new Actor("operator8", ActorType.OPERATOR);
            Actor operator9 = new Actor("operator9", ActorType.OPERATOR);
            Actor operator10 = new Actor("operator10", ActorType.OPERATOR);
            operators.add(operator1);
            operators.add(operator2);
            operators.add(operator3);
            operators.add(operator4);
            operators.add(operator5);
            operators.add(operator6);
            operators.add(operator7);
            operators.add(operator8);
            operators.add(operator9);
            operators.add(operator10);
            ArrayBlockingQueue<Actor> directors = new ArrayBlockingQueue<Actor>(10);
            Actor director1 = new Actor("director1", ActorType.DIRECTOR);
            Actor director2 = new Actor("director2", ActorType.DIRECTOR);
            Actor director3 = new Actor("director3", ActorType.DIRECTOR);
            Actor director4 = new Actor("director4", ActorType.DIRECTOR);
            Actor director5 = new Actor("director5", ActorType.DIRECTOR);
            Actor director6 = new Actor("director6", ActorType.DIRECTOR);
            Actor director7 = new Actor("director7", ActorType.DIRECTOR);
            Actor director8 = new Actor("director8", ActorType.DIRECTOR);
            Actor director9 = new Actor("director9", ActorType.DIRECTOR);
            Actor director10 = new Actor("director110", ActorType.DIRECTOR);
            directors.add(director1);
            directors.add(director2);
            directors.add(director3);
            directors.add(director4);
            directors.add(director5);
            directors.add(director6);
            directors.add(director7);
            directors.add(director8);
            directors.add(director9);
            directors.add(director10);
            dispatcher = new Dispatcher(operators, supervisors,directors);
        }
        return dispatcher;
    }
}
