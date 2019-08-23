package com.st.bean;

import javax.persistence.*;

@Entity
@Table
public class StackBean {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private long stackId;
    @Column
    private String name;
    @Column
    private long cost;

    public StackBean() {
    }

    public StackBean(long stackId,String name, long cost) {
        this.stackId = stackId;
        this.name = name;
        this.cost = cost;
    }

    public long getStackId() {
        return stackId;
    }

    public void setStackId(long stackId) {
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
