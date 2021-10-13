package com.dbc.core.infrastructure;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.core.exception.SicrediRegisterNotFoundException;

public class CRUDServiceImpl<E extends Serializable, R extends JpaRepository<E, Integer>> implements CRUDService<E> {

	private R repository;

	private List<Consumer<E>> beforeInserts;
	private List<Consumer<E>> afterInserts;

	private List<Consumer<E>> beforeUpdates;
	private List<Consumer<E>> afterUpdates;

	private List<Consumer<E>> beforeDeletes;
	private List<Consumer<E>> afterDeletes;

	public CRUDServiceImpl(R repository) {
		this.repository = repository;
	}

	public void beforeInsert(Consumer<E> onPreInsert) {
		beforeInserts = addEvent(beforeInserts, onPreInsert);
	}

	public void afterInsert(Consumer<E> onPostInsert) {
		afterInserts = addEvent(afterInserts, onPostInsert);
	}

	public void beforeUpdate(Consumer<E> onPreUpdate) {
		beforeUpdates = addEvent(beforeUpdates, onPreUpdate);
	}

	public void afterUpdate(Consumer<E> onPostUpdate) {
		afterUpdates = addEvent(afterUpdates, onPostUpdate);
	}

	public void beforeDelete(Consumer<E> onPreDelete) {
		beforeDeletes = addEvent(beforeDeletes, onPreDelete);
	}

	public void afterDelete(Consumer<E> onPostDelete) {
		afterDeletes = addEvent(afterDeletes, onPostDelete);
	}

	private List<Consumer<E>> addEvent(List<Consumer<E>> eventsList, Consumer<E> event) {
		if (eventsList == null) {
			eventsList = new ArrayList<Consumer<E>>();
		}
		eventsList.add(event);
		return eventsList;
	}

	private void executeConsumers(List<Consumer<E>> consumers, E entity) {
		if (consumers != null) {
			for (Consumer<E> consumer : consumers) {
				consumer.accept(entity);
			}
		}
	}

	@Override
	public List<E> findAll() {
		return repository.findAll();
	}

	@Override
	public E insert(E entity) {

		this.validationForInsertOrUpdate(entity);

		this.executeConsumers(beforeInserts, entity);

		entity = repository.save(entity);

		this.executeConsumers(afterInserts, entity);

		return entity;

	}

	@Override
	public E update(E entity) {

		this.validationForInsertOrUpdate(entity);

		this.executeConsumers(beforeUpdates, entity);

		entity = repository.save(entity);

		this.executeConsumers(afterUpdates, entity);

		return entity;
	}

	@Override
	public void delete(Integer idEntity) {

		Optional<E> found = repository.findById(idEntity);

		if (found.isEmpty()) {
			throw new SicrediRegisterNotFoundException(getEntityClass().getSimpleName(), idEntity);
		}

		this.executeConsumers(beforeDeletes, found.get());

		repository.delete(found.get());

		this.executeConsumers(afterDeletes, found.get());

	}

	@Override
	public E find(Integer primaryKey) {
		Optional<E> entity = repository.findById(primaryKey);
		if (entity.isPresent()) {
			return entity.get();
		}
		return null;
	}

	@Override
	public Page<E> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public R getRepository() {
		return repository;
	}

	@SuppressWarnings("unchecked")
	public Class<E> getEntityClass() {
		Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
		return (Class<E>) actualTypeArguments[0];
	}

	@Override
	public List<E> findAllById(List<Integer> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void validationForInsertOrUpdate(E entity) {
	}
}
