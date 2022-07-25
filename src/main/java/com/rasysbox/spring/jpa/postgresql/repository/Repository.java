package com.rasysbox.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rasysbox.spring.jpa.postgresql.model.Model;

public interface Repository extends JpaRepository<Model, Long> {
  List<Model> findByEstado(boolean estado);
  List<Model> findByNombre(String nombre);
}
