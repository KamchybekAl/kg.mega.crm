package dao;

import model.Mentor;

public interface MentorDao extends CrudDao {

    void save (Mentor mentor) ;

    Mentor [] findAll() ;
}

