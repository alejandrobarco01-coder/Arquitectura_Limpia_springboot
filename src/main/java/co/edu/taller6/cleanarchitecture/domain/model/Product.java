package co.edu.taller6.cleanarchitecture.domain.model;

/** Domain entity shared with Angular's Product contract. */
public record Product(Long id, String name, String category, double price) { }
