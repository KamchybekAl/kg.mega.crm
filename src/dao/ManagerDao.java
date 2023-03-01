package dao;

import model.Manager;

public interface ManagerDao extends CrudDao {
    void save(Manager manager) ;

    Manager[] findAll() ;
}
