package edu.miu.cs.cs425.eregistrarwebapi.controller;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.eregistrarwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> get(){
        List<Student> students = studentService.allStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getByID(@PathVariable Long id) throws StudentNotFoundException{
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/register")
    public ResponseEntity<Student> register(@Valid @RequestBody StudentRequest studentRequest){
        Student student = studentService.save(studentRequest,null);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Student> update(@Valid @RequestBody StudentRequest studentRequest,@PathVariable Long id){
        Student student = studentService.update(studentRequest,id);
        return  ResponseEntity.ok(student);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws StudentNotFoundException {
        studentService.delete(id);
        return ResponseEntity.ok("Success");
    }
}
