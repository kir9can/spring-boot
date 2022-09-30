package by.tms.springboot.Dao;

import by.tms.springboot.entity.Operation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryOperationDao {
    private final List<Operation> operations = new ArrayList<>();
    public void save(Operation operation) {
        operations.add(operation);
    }

    public List<Operation> findAll() {
        return operations;
    }
}
