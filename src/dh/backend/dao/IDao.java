package dh.backend.dao;

import java.util.List;

public interface IDao <T>{

    public abstract T registrar (T t);
    public abstract List<T> buscarTodos();

}
