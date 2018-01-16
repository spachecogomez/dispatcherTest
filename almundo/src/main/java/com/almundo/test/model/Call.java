package com.almundo.test.model;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

/**
 *
 * This class represents the relevant information for an actor within the system.
 *
 * @author Sebastian Pacheco
 * @version 1.0
 *
 * Created by sebastianpacheco on 14/01/18.
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.StringIdGenerator.class, property="@id")
public class Call {

    public Call(){

    }

    public Call(String customerName){
        this.customerName = customerName;
    }

    private String customerName;

    private Date callStartDate;

    private Date callEndDate;

    private Actor attendant;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCallStartDate() {
        return callStartDate;
    }

    public void setCallStartDate(Date callStartDate) {
        this.callStartDate = callStartDate;
    }

    public Date getCallEndDate() {
        return callEndDate;
    }

    public void setCallEndDate(Date callEndDate) {
        this.callEndDate = callEndDate;
    }

    public Actor getAttendant() {
        return attendant;
    }

    public void setAttendant(Actor attendant) {
        this.attendant = attendant;
    }

    @Override
    public String toString(){
        return String.format("[Call| CustomerName: %s]",this.customerName);
    }


}
