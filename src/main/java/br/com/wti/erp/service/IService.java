package br.com.wti.erp.service;

import java.util.List;

import br.com.wti.erp.repository.Filter;

public interface IService<T> {

	public List<T> findAll();

	public List<T> findAllByParam(Filter filter);

	public T findById(Integer id);

	public void save(T entity);
}
