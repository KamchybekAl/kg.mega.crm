package dao;

import model.CourseFormat;

public interface CourseFormatDao extends CrudDao {

    void save(CourseFormat courseFormat) ;

    CourseFormat[] findAll();

}

