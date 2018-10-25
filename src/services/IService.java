package services;

import java.util.List;

public interface IService<T,ID> {
	List<T> findAll();
	T findById(ID id);
	int save(T entity);
	int update(T entity);
	int delete(ID id);
}
