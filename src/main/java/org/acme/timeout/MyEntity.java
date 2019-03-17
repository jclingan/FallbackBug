package org.acme.timeout;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Table(name = "ENTITY")
@Entity
public class MyEntity extends PanacheEntity {
    public String mystring;
}