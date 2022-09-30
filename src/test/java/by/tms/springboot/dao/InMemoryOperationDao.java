package by.tms.springboot.dao;

import by.tms.springboot.entity.Operation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationDao {
    private final List<Operation> operations = new ArrayList<>();
    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> findAll(){
        return operations;
    }
}
