package eu.arrowhead.application.skeleton.provider.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "descricao")
    private String description;

    @Column(name = "minimo")
    private Integer min;

    @Column(name = "maximo")
    private Integer max;

    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
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
    @Override
    public String toString() {
        return "Sensor [id=" + id + ", min=" + min + ", max=" + max + ", data=" + data + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @PrePersist
    protected void onCreate() {
        data = new Date();  // Define a data atual quando o sensor é criado
    }

    @PreUpdate
    protected void onUpdate() {
        data = new Date();  // Atualiza a data para a data atual quando o sensor é atualizado
    }
}
