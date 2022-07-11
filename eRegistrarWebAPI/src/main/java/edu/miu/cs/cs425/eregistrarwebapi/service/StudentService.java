package edu.miu.cs.cs425.eregistrarwebapi.service;


import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> allStudent();

    Student getStudent(Long id) throws StudentNotFoundException;

    void delete(Long id) throws StudentNotFoundException;

    Student save(StudentRequest student,Long id);

    Student update(StudentRequest student, Long id);


}
