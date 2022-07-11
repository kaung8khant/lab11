package edu.miu.cs.cs425.eregistrarwebapi.service.implementation;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> allStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) throws StudentNotFoundException {
        return getStudentByID(id);
    }

    @Override
    public void delete(Long id) throws StudentNotFoundException{
        Student student = getStudentByID(id);
        studentRepository.delete(student);
    }

    @Override
    public Student save(StudentRequest studentRequest,Long id) {
        Student student = getStudentFromDTO(studentRequest,id);
        return studentRepository.save(student);
    }

    @Override
    public Student update(StudentRequest studentRequest, Long id) {
       return save(studentRequest,id);
    }
    private Student getStudentFromDTO(StudentRequest studentRequest,Long id){
        return Student.build(
                id,
                studentRequest.getStudentNumber(),
                studentRequest.getFirstName(),
                studentRequest.getMiddleName(),
                studentRequest.getLastName(),
                studentRequest.getCgpa(),
                studentRequest.getEnrollmentDate(),
                studentRequest.getIsInternational());

    }

    private Student getStudentByID(Long id) throws StudentNotFoundException{
        Student stu = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(String.format("Student not found!")));
        return stu;
    }
}
