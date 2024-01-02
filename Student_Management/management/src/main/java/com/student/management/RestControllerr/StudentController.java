package com.student.management.RestControllerr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.response.BasicResponseMsg;
import com.student.management.response.StudentRequestVo;
import com.student.management.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStd")
    public ResponseEntity<BasicResponseMsg> saveStudent(@RequestBody StudentRequestVo studentRequestVo) {

        BasicResponseMsg response = new BasicResponseMsg();

        try {
            response = studentService.saveStudent(studentRequestVo);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getStd/{id}")
    public ResponseEntity<BasicResponseMsg> getStudent(@PathVariable("id") long id) {
                BasicResponseMsg response = new BasicResponseMsg();

        try {
            response=studentService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<BasicResponseMsg> getStudentAll() {
                BasicResponseMsg response = new BasicResponseMsg();

        try {
            response=studentService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

     @PutMapping("/updateStd/{id}")
    public ResponseEntity<BasicResponseMsg> updateStudent(@RequestBody StudentRequestVo studentRequestVo,@PathVariable("id") long id) {
                BasicResponseMsg response = new BasicResponseMsg();

        try {
            response=studentService.getUpdateStudent(studentRequestVo, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
