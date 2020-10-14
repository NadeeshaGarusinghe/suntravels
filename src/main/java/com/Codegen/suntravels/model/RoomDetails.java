package com.Codegen.suntravels.model;

import lombok.*;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomDetails {
    @Id
    @GeneratedValue
    private int rdetailsid;
    private double rprice;
    private int maxadults;
    private int availablerooms;


}
