package Grupo3.IntegradoraFinal.service;

import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;

import java.util.List;

public interface IService<T>{
    T getById(Long id) throws ResourceNotFoundException;
    List<T> getByAll() throws ResourceNotFoundException;
    String delete(Long id) throws ResourceNotFoundException;
}
