package co.edu.taller6.cleanarchitecture.domain.model;

/** Domain entity shared with Angular's User contract. */
public record User(Long id, String name, String lastName, int age, String email, String engineering) { }
