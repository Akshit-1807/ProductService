package com.example.productservice.InheritanceRelation.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);

    void save(com.example.productservice.InheritanceRelation.mappedsuperclass.Student student);
}
