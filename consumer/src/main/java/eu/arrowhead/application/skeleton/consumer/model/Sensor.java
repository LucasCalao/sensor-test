package eu.arrowhead.application.skeleton.consumer.model;

import java.util.Date;


public class Sensor {

    private Long id;
    private String name;
    private String description;
    private Integer min;
    private Integer max;
    private Date data;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getMin() {
        return min;
    }
    public void setMin(Integer min) {
        this.min = min;
    }
    public Integer getMax() {
        return max;
    }
    public void setMax(Integer max) {
        this.max = max;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Sensor [id=" + id + ", min=" + min + ", max=" + max + ", data=" + data + "]";
    }

    //methods

    public Sensor(){}

    public Sensor(final String name, final String description, Integer min, Integer max){
        this.name=name;
        this.description=description;
        this.min=min;
        this.max=max;
    }

    public Sensor(Long id, final String name, final String description, Integer min, Integer max){
        this.id=id;
        this.name=name;
        this.description=description;
        this.min=min;
        this.max=max;
    }

}
