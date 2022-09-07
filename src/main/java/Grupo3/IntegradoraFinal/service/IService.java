package Grupo3.IntegradoraFinal.service;

import java.util.List;

public interface IService<T>{
    T create(T t);
    T getById(int id);
    List<T> getByAll();
    String delete(int id);
    T update( int id,T t);
}
