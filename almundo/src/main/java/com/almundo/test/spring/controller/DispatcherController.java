package com.almundo.test.spring.controller;

import com.almundo.test.dispatcher.Dispatcher;
import com.almundo.test.model.Actor;
import com.almundo.test.model.Call;
import com.almundo.test.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sebastianpacheco on 14/01/18.
 */
@RestController
public class DispatcherController {

    private Logger log = LoggerFactory.getLogger(DispatcherController.class);

    @Autowired
    private Dispatcher dispatcher;

    @RequestMapping(path = "/v1/dispatch",method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Call> dispatchCall(@RequestBody Call call) throws Exception{
        call.setCallStartDate(new Date());
        log.debug(String.format("Received Call to dispatch: %s",call));
        Actor actor = dispatcher.dispatchCall(call);
        call.setAttendant(actor);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        log.debug(String.format("Call attended by : %s at %s", actor, df.format(call.getCallStartDate())));
        return ResponseEntity.ok(call);
    }

    @RequestMapping(path = "/v1/dispatch",method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public void endCall(@RequestBody  Call call){
        log.debug(String.format("Call to be ended: %s",call.getAttendant()));
        dispatcher.enqueueActor(call.getAttendant());
    }

    @RequestMapping(path = "/v1/status", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public Status getStatus(){
        return dispatcher.getStatus();
    }
}
