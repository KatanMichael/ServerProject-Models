package com.models;


import org.hibernate.annotations.Entity;

@Entity
public class Activity
{
    private int id;
    private String name;
    private boolean hasSets;
    private int numberOfSets;

    public Activity(){}

    public Activity(String name, boolean hasSets, int numberOfSets)
    {

        this.name = name;
        this.hasSets = hasSets;
        this.numberOfSets = numberOfSets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasSets() {
        return hasSets;
    }

    public void setHasSets(boolean hasSets) {
        this.hasSets = hasSets;
    }

    public int getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(int numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasSets=" + hasSets +
                ", numberOfSets=" + numberOfSets +
                '}';
    }
}
