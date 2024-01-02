package com.student.management.service;

import com.student.management.response.BasicResponseMsg;
import com.student.management.response.StudentRequestVo;

public interface StudentService {

    BasicResponseMsg saveStudent(StudentRequestVo studentRequestVo);

    BasicResponseMsg getById(long id);

    BasicResponseMsg getAll();

    BasicResponseMsg getUpdateStudent(StudentRequestVo studentRequestVo, long id);
    
}
