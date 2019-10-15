package com.congdat.notaryweb.api;

import org.springframework.http.ResponseEntity;

public abstract class AbstractApi<T, U, S> {

		public abstract ResponseEntity findAll();

		public abstract ResponseEntity save(T agr, S username);

		public abstract ResponseEntity update(T agr, U id, S username);

		public abstract ResponseEntity delete(U id);
}
