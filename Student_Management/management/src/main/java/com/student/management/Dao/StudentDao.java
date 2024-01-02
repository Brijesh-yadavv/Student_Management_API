package com.student.management.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.management.Model.Student;



public interface StudentDao extends JpaRepository<Student,Long>{

    
} 