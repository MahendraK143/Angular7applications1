package com.stack.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stack")
public class StackBean {
    @Id
    @GeneratedValue
    private Integer stackId;
    private String name;
    private long cost;

    public Integer getStackId() {
        return stackId;
    }

    public void setStackId(Integer stackId) {
        this.stackId = stackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "StackBean{" +
                "stackId=" + stackId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
