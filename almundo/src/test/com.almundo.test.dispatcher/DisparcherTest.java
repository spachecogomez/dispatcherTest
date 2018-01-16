package com.almundo.test.dispatcher;


import com.almundo.test.model.Actor;
import com.almundo.test.model.Call;
import com.almundo.test.model.exception.NoAgentAvailable;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@RunWith(ConcurrentTestRunner.class)
public class DisparcherTest {

    private Logger log = LoggerFactory.getLogger("DisparcherTest");

    private Call call;

    private List<Actor> agents;


    public DisparcherTest(){
        call = new Call("MockCustomer");
        agents = new ArrayList<Actor>();
    }

    @Test
    public void firstCall() throws NoAgentAvailable {
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void secondCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void thirdCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void fourthCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void fifthCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void sixthCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void seventhCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void eighthCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void ninethCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }

    @Test
    public void tenthCall() throws NoAgentAvailable{
        log.info(String.format("DispatcherSingleton.getInstance() %s", DispatcherSingleton.getInstance().hashCode()));
        Actor attendant = DispatcherSingleton.getInstance().dispatchCall(call);
        Assert.assertFalse(containedInList(attendant));
        log.info(String.format("Call sent by the thread %s Attended by %s", Thread.currentThread().getName(), attendant.getName()));
        addToList(attendant);
    }


    private synchronized void addToList(Actor actor){
        agents.add(actor);
    }

    private synchronized boolean containedInList(Actor actor){
        return agents.contains(actor);
    }
}
