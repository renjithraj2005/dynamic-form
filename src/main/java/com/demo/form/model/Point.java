package com.demo.form.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name =  "Point")
@Table(name = "point")
public class Point extends BaseModel{
    @Column(name = "name", nullable = false)
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "point", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Node> nodes;

    public Point() {
    }

    public Point(String name) {
        this.name = name;
        this.nodes = new HashSet<Node>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
