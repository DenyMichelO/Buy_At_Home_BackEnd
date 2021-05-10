package com.buyathome.backend.dto;

public class NieghbourGet {

    private Integer neighbourId;
    private String name;

    public NieghbourGet(){
    }

    public Integer getNeighbourId() { return neighbourId; }
    public void setNeighbourId(Integer neighbourId) { this.neighbourId = neighbourId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "NieghbourGet{" +
                "neighbourId=" + neighbourId +
                ", name='" + name + '\'' +
                '}';
    }
}
