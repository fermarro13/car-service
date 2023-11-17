package com.example.api.rest.carservice.model;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbid")
    private Long dbid;

    @Column(name = "plate", unique = true)
    private String plate;

    @ManyToOne(cascade = {})
    @JoinColumn(name = "color",referencedColumnName = "dbid")
    private Color color;

    @Version
    private Long version = 0L;

    public Car() {
    }

    public Long getDbid() {
        return dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Car{" +
                "dbid=" + dbid +
                ", plate='" + plate + '\'' +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return dbid != null && Objects.equals(dbid, car.dbid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
