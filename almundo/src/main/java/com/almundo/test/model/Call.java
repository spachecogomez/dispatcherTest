package com.almundo.test.model;

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
public class Call {

    private String customerName;

    private Date callStartDate;

    private Date callEndDate;


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
}
