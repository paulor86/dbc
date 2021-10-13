package com.dbc.core.infrastructure;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface CRUDService<E extends Serializable> {

	E insert(E entity);

	E update(E entity);

	void delete(Integer idEntity);

	E find(Integer primaryKey);

	List<E> findAll();

	Page<E> findAll(Pageable pageable);

	List<E> findAllById(List<Integer> ids);

	void validationForInsertOrUpdate(E entity);
}
