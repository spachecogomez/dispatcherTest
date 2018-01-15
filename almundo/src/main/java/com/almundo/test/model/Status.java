package com.almundo.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Status {

    private int availableOperators;

    private int availableSupervisors;

    private int availableDirectors;

    public int getAvailableOperators() {
        return availableOperators;
    }

    public void setAvailableOperators(int availableOperators) {
        this.availableOperators = availableOperators;
    }

    public int getAvailableSupervisors() {
        return availableSupervisors;
    }

    public void setAvailableSupervisors(int availableSupervisors) {
        this.availableSupervisors = availableSupervisors;
    }

    public int getAvailableDirectors() {
        return availableDirectors;
    }

    public void setAvailableDirectors(int availableDirectors) {
        this.availableDirectors = availableDirectors;
    }
}
