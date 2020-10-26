package com.Codegen.suntravels.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name="hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel {

    @Id
    @GeneratedValue
    private int hid;
    private String name;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)               //one to one relationship
    @JoinColumn(name = "locationid")
    private Location location;

    //getters and setters
    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
