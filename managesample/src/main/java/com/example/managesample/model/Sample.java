package com.example.managesample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sample")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "code")
    String code;
    @Column(name = "path")
    String path;
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Label.class, mappedBy = "sampleId", cascade = CascadeType.ALL)
    private List<Label> labels;

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public Sample() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
