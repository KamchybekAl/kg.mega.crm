package dao;

import model.Group;

public interface GroupDao extends CrudDao{

    void save(Group group);

    Group [] findAll() ;

}
