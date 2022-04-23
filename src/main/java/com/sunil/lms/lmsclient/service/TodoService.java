package com.sunil.lms.lmsclient.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sunil.lms.lmsclient.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    
    static {
        todos.add(new Todo(1, "Sunil", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2, "Sunil", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "Sunil", "Learn Hibernate", new Date(),
                false));
    }
    
    public List<Todo> retrieveTodos(String user) {
    	
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
        	System.out.println(todo);
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        
        System.out.println(filteredTodos);
        return filteredTodos;
    }
	
}
