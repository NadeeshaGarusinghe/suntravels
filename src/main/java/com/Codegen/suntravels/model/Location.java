package com.Codegen.suntravels.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Location {
    @Id
    @GeneratedValue
    private int locaionid;
    private String parent;
    private String child;

    //getters and setters
    public int getLocaionid() {
        return locaionid;
    }

    public void setLocaionid(int locaionid) {
        this.locaionid = locaionid;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}
