package com.example.managesample.model;

import javax.persistence.*;

@Entity
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "x_center")
    Double xCenter;
    @Column(name = "y_center")
    Double yCenter;
    @Column(name = "width")
    Double width;
    @Column(name = "height")
    Double height;
    @JoinColumn(name = "sample_id", nullable = false)
    private Integer sampleId;

    public Label() {
    }

    public Label(Label label) {
        this.width= label.width;
        this.height= label.height;
        this.xCenter= label.xCenter;
        this.yCenter= label.yCenter;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }

    public Integer getId() {
        return id;
    }

    public Double getxCenter() {
        return xCenter;
    }

    public Double getyCenter() {
        return yCenter;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public Integer getSampleId() {
        return sampleId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setxCenter(Double xCenter) {
        this.xCenter = xCenter;
    }

    public void setyCenter(Double yCenter) {
        this.yCenter = yCenter;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

//    public void setSample(Sample sample) {
//        this.sample = sample;
//    }
}
