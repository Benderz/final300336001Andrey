package com.example.LaboratoryExercise4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseServiceTest {

    @InjectMocks
    private DatabaseService panel;

    @Mock
    private Connection connection;

    @Mock
    private ResultSet result;

    @Mock
    private Connection123 cc;

    @Mock
    private PreparedStatement stmt;

    Category cat;

    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.openMocks(this);

        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
        when(cc.connect()).thenReturn(connection);

        cat= new Category("1157","Joy Ramirez","100000","5","Business");


    }

    @Test
    void add() throws SQLException, ClassNotFoundException {
        Mockito.when(connection.prepareStatement(("INSERT INTO Category VALUES ( ?, ? ,?,?,?)"))).thenReturn((PreparedStatement) stmt);

        panel.add(cat);

        Mockito.verify(stmt).executeUpdate();
    }

    @Test
    void edit() {
    }

    @Test
    void delete() {
    }

    @Test
    void search() {
    }

    @Test
    void display() throws SQLException, ClassNotFoundException {
        when(result.next()).thenReturn(true,false);
        when(result.getString("clientno")).thenReturn("1157");
        when(result.getString("clientname")).thenReturn("Joy Ramirez");
        when(result.getString("loanamount")).thenReturn("100000");
        when(result.getString("years")).thenReturn("5");
        when(result.getString("loantype")).thenReturn("Business");
        Mockito.doReturn(result).when(stmt).executeQuery();
        panel.display();
        Mockito.verify(stmt).executeQuery();
    }
    
}