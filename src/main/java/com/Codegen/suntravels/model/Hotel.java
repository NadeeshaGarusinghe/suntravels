package com.Codegen.suntravels.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "locationid")
    private Location location;





}
