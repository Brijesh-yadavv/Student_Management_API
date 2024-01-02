package com.student.management.service_impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.Dao.StudentDao;
import com.student.management.Model.Student;
import com.student.management.response.BasicResponseMsg;
import com.student.management.response.StudentRequestVo;
import com.student.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao stdDao;

    @Override
    public BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo) {

        BasicResponseMsg response = new BasicResponseMsg();
        try {
            Student std = new Student();
            std.setName(studentRequestVo.getName());
            std.setAge(studentRequestVo.getAge());
            std.setRollNo(studentRequestVo.getRollNo());
            std.setAdd(studentRequestVo.getAdd());
            std.setMobileNo(studentRequestVo.getMobileNo());
            Student s = stdDao.save(std);
            response.setData(s.getId());
            response.setMsge("student is saved..");
            response.setStatus(200);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    @Override
    public BasicResponseMsg getById(long id) {

        BasicResponseMsg response = new BasicResponseMsg();
        try {
            Optional<Student> std = stdDao.findById((long) id);
            if (std.isPresent()) {
                Student s = std.get();
                response.setStatus(200);
                response.setMsge("data found");
                response.setData(s);
            } else {
                response.setStatus(400);
                response.setMsge("data not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BasicResponseMsg getAll() {
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            List<Student> list = stdDao.findAll();
            if (!list.isEmpty()) {
                response.setMsge("data found");
                response.setStatus(200);
                response.setData(list);
            } else {
                response.setStatus(400);
                response.setMsge("data not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public BasicResponseMsg getUpdateStudent(StudentRequestVo studentRequestVo, long id) {
        System.out.println(studentRequestVo);
        BasicResponseMsg response = new BasicResponseMsg();
        try {
            Optional<Student> std = stdDao.findById((long) id);
            if (std.isPresent()) {
                Student s = std.get();
                System.out.println(s);

                // s.setId(studentRequestVo.getId());
                s.setAdd(studentRequestVo.getAdd());
                s.setAge(studentRequestVo.getAge());
                s.setName(studentRequestVo.getName());
                s.setMobileNo(studentRequestVo.getMobileNo());
                Student save = stdDao.save(s);
                response.setMsge("student updated");
                response.setStatus(200);
                response.setData(save.getId());

            } else {
                response.setStatus(400);
                response.setMsge("data not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
