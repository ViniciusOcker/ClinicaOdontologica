package Grupo3.IntegradoraFinal.service;

import java.util.List;

public interface IService<T>{
    T getById(Long id);
    List<T> getByAll();
    String delete(Long id);
}
