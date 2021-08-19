package com.example.LaboratoryExercise4;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Categoryservice {



    private static List<Category> todos = new ArrayList<Category>();
    //private static int todoCount = 2;

    static {
        todos.add(new Category("1157","Joy Ramirez","100000","5","Business"));
        todos.add(new Category("1005","Josaphat Dee","5000","1","Personal"));

    }

    public void initialadd(){

        todos.add(new Category("1157","Joy Ramirez","100000","5","Business"));
        todos.add(new Category("1157","Joy Ramirez","100000","5","Business"));

    }


    public List<Category> retrieveTodos() {
        List<Category> filteredTodos = new ArrayList<Category>();
        for (Category todo : todos) {
            filteredTodos.add(todo);
        }
        return filteredTodos;    }

    public void addTodo(String clientno, String clientname,String loanamount,String years,String loantype) {
        todos.add(new Category(clientno,clientname,loanamount,years,loantype));
    }


    public void deleteTodo(String id) {

        for (int i = 0; i < todos.size(); i++) {

            if(id.equals(todos.get(i).getClientno())) {

                todos.remove(i);
                break;
            }



        }


    }

    public Category retrieve(String id){

        for(Category todo: todos){
            if(todo.getClientno().equals(id)){
                return todo;
            }
        }
        return null;

    }

    public void update(Category todo){
        todos.remove(todo);
        todos.add(todo);
    }


}
