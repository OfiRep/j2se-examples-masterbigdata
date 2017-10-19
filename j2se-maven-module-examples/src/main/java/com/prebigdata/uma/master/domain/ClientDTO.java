package com.prebigdata.uma.master.domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity(value = "client", noClassnameStored = true)
public class ClientDTO {
    
    @Id
    @Property(value="_id")
    public ObjectId id;
    
    @Property(value="name")
    public String name;
    
    @Property(value="surname")
    public String surname;
    
    @Property(value="city")
    public String city;
    
    public ClientDTO() {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.city = null;
    }
}
