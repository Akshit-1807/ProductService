package com.example.productservice.InheritanceRelation.TablePerClass;

import com.example.productservice.InheritanceRelation.mappedsuperclass.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mentorRepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Override
    Mentor save(Mentor mentor);

    void save(com.example.productservice.InheritanceRelation.TablePerClass.Mentor mentor);
}
