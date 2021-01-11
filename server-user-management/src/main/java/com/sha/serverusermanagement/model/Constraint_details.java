package com.sha.serverusermanagement.model;

public class Constraint_details {
    private String owner ;
    private String constraint_name;
    private String constrain_type;
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getConstraint_name() {
        return constraint_name;
    }
    public void setConstraint_name(String constraint_name) {
        this.constraint_name = constraint_name;
    }
    public String getConstrain_type() {
        return constrain_type;
    }
    public void setConstrain_type(String constrain_type) {
        this.constrain_type = constrain_type;
    }
}
