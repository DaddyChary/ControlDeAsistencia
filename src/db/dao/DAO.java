package db.dao;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author DaddyChary
 * @param <T>
 */
public interface DAO<T> {
    
    public void create(T t) throws SQLException;
    public void update(T t) throws SQLException;
    public void delete(T t) throws SQLException;
    public T getOne(int id) throws SQLException;
    public List<T> getAll() throws SQLException;
    
}
