package com.myvkr.vkr.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of={"id","link"})
@EqualsAndHashCode(of={"id"})
public class TimeSeries {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean isDouble;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDouble() {
        return isDouble;
    }

    public void setDouble(Boolean aDouble) {
        isDouble = aDouble;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;
}
