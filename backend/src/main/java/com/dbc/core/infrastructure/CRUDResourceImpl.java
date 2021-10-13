package com.dbc.core.infrastructure;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.dbc.core.exception.SicrediException;
import com.dbc.core.exception.SicrediRegisterNotFoundException;
import com.dbc.sicredi.common.map.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Transactional
public class CRUDResourceImpl<D extends Serializable, E extends Serializable, S extends CRUDService<E>, M extends Map<D, E>>
		implements CRUDResource<D> {

	private static final String INTERNAL_SERVER_ERROR = "Erro interno";

	private S service;

	private M mapper;

	public CRUDResourceImpl(S service, M mapper) {
		this.mapper = mapper;
		this.service = service;
	}

	@Override
	public ResponseEntity<Object> findAll(Pageable pageable) {
		try {

			return new ResponseEntity<>(service.findAll(pageable).map(p -> mapper.toDto(p)), HttpStatus.OK);

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ei) {

			log.error(INTERNAL_SERVER_ERROR, ei);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Object> findAll() {
		try {
			return new ResponseEntity<>(getMapper().entitiesToDtos(service.findAll()), HttpStatus.OK);

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ei) {

			log.error(INTERNAL_SERVER_ERROR, ei);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Object> findByID(Integer id) {
		try {

			return new ResponseEntity<>(mapper.toDto(service.find(id)), HttpStatus.OK);

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ei) {

			log.error(INTERNAL_SERVER_ERROR, ei);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Object> insert(D dto) {
		try {

			return new ResponseEntity<>(mapper.toDto(service.insert(mapper.toEntity(dto))), HttpStatus.OK);

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ei) {

			log.error(INTERNAL_SERVER_ERROR, ei);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Object> update(D dto) {
		try {

			return new ResponseEntity<>(mapper.toDto(service.update(mapper.toEntity(dto))), HttpStatus.OK);

		} catch (SicrediRegisterNotFoundException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ei) {

			log.error(INTERNAL_SERVER_ERROR, ei);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Object> delete(Integer id) {
		try {

			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (SicrediException e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());
		} catch (SicrediRegisterNotFoundException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
					.body(e.getMessage());

		} catch (Exception ex) {

			log.error(INTERNAL_SERVER_ERROR, ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(INTERNAL_SERVER_ERROR);

		}

	}

	public S getService() {
		return service;
	}

	public M getMapper() {
		return mapper;
	}

	public static String getInternalError() {
		return INTERNAL_SERVER_ERROR;
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleInternalException(Exception ex, WebRequest request) {
		log.catching(ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
				.body(INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { SicrediException.class })
	protected ResponseEntity<Object> handleBusinessException(SicrediException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
				.body(ex.getMessage());
	}
}
