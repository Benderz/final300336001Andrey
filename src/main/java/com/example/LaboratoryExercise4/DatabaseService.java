package com.example.LaboratoryExercise4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;
    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(Category cat) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO loantable VALUES ( ?, ? , ?, ?, ?)";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, cat.getClientno());
        query.setString(2, cat.getClientname());
        query.setString(3, cat.getLoanamount());
        query.setString(4, cat.getYears());
        query.setString(5, cat.getLoantype());
        query.executeUpdate();
    }

    @Override
    public Category edit(Category cat, String clientno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update loantable set clientno=?,clientname=?,loanamount=?,years=?,loantype=? where clientno=?");
        query.setString(1, cat.getClientno());
        query.setString(2, cat.getClientname());
        query.setString(3, cat.getLoanamount());
        query.setString(4, cat.getYears());
        query.setString(5, cat.getLoantype());
        query.setString(6, clientno);
        query.executeUpdate();
        return cat;
    }

    @Override
    public void delete(String clientno) throws SQLException {
        String quer1 = "Delete from loantable where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        query.executeUpdate();
    }

    public Category search(String clientno) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from loantable where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Category obj1=null;
        obj1 = new Category(rs.getString("clientno"), rs.getString("clientname"), rs.getString("loanamount"), rs.getString("years"), rs.getString("loantype"));
        return obj1;
    }

    @Override
    public List<Category> display() throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Category> Catlist = new ArrayList<Category>();
        String quer1 = "Select * from loantable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Category obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Category(rs.getString("clientno"), rs.getString("clientname"), rs.getString("loanamount"), rs.getString("years"), rs.getString("loantype"));
            Catlist.add(obj1);
        }
        return Catlist;
    }

    public List<Items> display2(String clientno) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Items> Itemlist = new ArrayList<Items>();
        String quer1 = "Select itemcode,itemdesc from items where catcode=?";//mod
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        ResultSet rs = query.executeQuery();
        Items obj2;
        //display records if there is data;
        while (rs.next()) {
            obj2 = new Items(rs.getString("itemcode"),rs.getString("itemdesc"));
            Itemlist.add(obj2);
        }
        return Itemlist;
    }
}
