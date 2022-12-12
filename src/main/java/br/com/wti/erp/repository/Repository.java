package br.com.wti.erp.repository;

import java.util.List;

public interface Repository<T> {

	public List<T> findAll();

	public List<T> findAllByParam(String paramSearch);

	public T findById(Integer id);

	public T save(T bean);
}
