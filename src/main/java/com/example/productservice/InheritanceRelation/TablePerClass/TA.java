package com.example.productservice.InheritanceRelation.TablePerClass;

import com.example.productservice.InheritanceRelation.mappedsuperclass.User;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_TA")
public class TA extends User {

    private String ta_session;
}
