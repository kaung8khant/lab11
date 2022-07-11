package edu.miu.cs.cs425.eregistrarwebapi.repository;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
