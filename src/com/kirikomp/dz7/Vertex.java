package com.kirikomp.dz7;

public class Vertex<T> {
    protected T payload;
    protected boolean visited;
    protected int weight;

    public Vertex(T payload) {
        this.payload = payload;
        this.visited = false;
        this.weight = -1;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
