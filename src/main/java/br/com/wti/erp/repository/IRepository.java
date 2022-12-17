package br.com.wti.erp.repository;

import java.util.List;

public interface IRepository<T> {

	public List<T> findAll();

	public List<T> findAllByParams(Filter filter);

	public T findById(Integer id);

	public T save(T entity);
}
