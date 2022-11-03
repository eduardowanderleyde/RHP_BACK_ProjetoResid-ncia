package com.RHPback.projeto.resource.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.RHPback.projeto.service.exceptions.DatabaseException;
import com.RHPback.projeto.service.exceptions.ResourceNotFoundException;

// tratamento manual dos erros.

	@ControllerAdvice // vai receptar as exceções para esse objeto posso tratar.
	public class ResourceExceptionHandler {

		@ExceptionHandler(ResourceNotFoundException.class)// intercepta as exceções pra aqui aí.
		public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) { // método que retorna um StrandError, recebe o ResourceNotFoundException
			String error = "Resource not found";
			HttpStatus status = HttpStatus.NOT_FOUND;//404
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI()); // o caminho saiu de request.
			return ResponseEntity.status(status).body(err); //. status para retornar com um código personalizado. o corpo vai ser o err.
		}

		@ExceptionHandler(DatabaseException.class)// intercepta as exceções pra aqui aí.
		public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) { // método que retorna um StrandError, recebe o ResourceNotFoundException
			String error = "Database error";
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),request.getRequestURI()); // o caminho saiu de request.
			return ResponseEntity.status(status).body(err); //. status para retornar com um código personalizado. o corpo vai ser o err.
		}
	}	
	

