/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150835.temporaryVariables.domain;

import csheets.core.Value;
import java.io.Serializable;
import java.util.Objects;

/**
 *  This class represents a temporary variable
 * 
 * @author Rui Braga
 */
public class TemporaryVariable implements Serializable {

    /**
     * Name of the temporary variable
     */
    private String name;
    /**
     * Value give to the temporary variable
     */
    private Value value;

    /**
     * Creates a variable with the name
     *
     * @param name of the temporary Variable
     */
    public TemporaryVariable(String name) {
        this.name = name;
        this.value = new Value();
    }

    /**
     * Creates a variable with the name and value
     *
     * @param name of the variable
     * @param value of the variable
     */
    public TemporaryVariable(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Constructor for an empty variable
     */
    public TemporaryVariable() {
        this.name = "";
        this.value = new Value();
    }

    /**
     * @return the value of the variable
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * @param value - the value of the variable
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * @return the name of the variable
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the string representation of the variable
     */
    @Override
    public String toString() {
        return name + " = " + value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.value);
        return hash;
    }

    /**
     * Compares two variables
     *
     * @param otherObject the other variable
     * @return true if equals, false if different
     */
    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null) {
            return false;
        }

        if (this == otherObject) {
            return true;
        }

        if (getClass() != otherObject.getClass()) {
            return false;
        }

        TemporaryVariable other = (TemporaryVariable) otherObject;
        return Objects.equals(this.name, other.name);
    }
}
