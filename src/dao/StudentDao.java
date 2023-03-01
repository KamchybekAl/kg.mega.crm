package dao;

import model.Student;

public interface StudentDao extends CrudDao {

    void save(Student student) ;

    Student[] findAll() ;
}
