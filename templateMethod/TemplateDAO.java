package br.edu.utfpr.dao;

import java.lang.reflect.GenericArrayType;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;

@Log
public abstract class TemplateDAO <T>{

    public Connection getConnection() {
        try (Connection conn = DriverManager.getConnection("jdbc:derby:memory:database;create=true")) 
        {
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verify(int rowsModified){
        if(rowsModified > 0)
            return true;
        return false;
    }

    public abstract boolean incluir(T obj);
    
    public abstract <T> List<T> listarTodos();

    public abstract boolean excluir(int id);

    public abstract boolean alterar(T obj);

}
