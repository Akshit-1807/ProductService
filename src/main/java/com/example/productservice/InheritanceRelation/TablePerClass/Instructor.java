package com.example.productservice.InheritanceRelation.TablePerClass;

import com.example.productservice.InheritanceRelation.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_Instructor")
public class Instructor extends User {

    private double avgRating;
}
