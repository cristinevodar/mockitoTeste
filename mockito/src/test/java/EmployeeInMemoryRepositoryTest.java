import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.mockito.Employee;
import test.mockito.EmployeeInMemoryRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
public class EmployeeInMemoryRepositoryTest {
     public List<Employee> employees= new ArrayList<Employee>();
     public EmployeeInMemoryRepository employeeInMemoryRepository;
    Employee employee1;
    Employee employee2;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("1", 243);
        employee2 = new Employee("2", 750);
        employeeInMemoryRepository = new EmployeeInMemoryRepository(employees);
    }

    @Test
    public void findAllTest(){
       List<Employee> employees2= new ArrayList<Employee>();
       assertEquals(employeeInMemoryRepository.findAll(),employees2);

        employees.add(employee1);
        employees.add(employee2);
        employees2.add(employee1);
        employees2.add(employee2);
        assertEquals(employeeInMemoryRepository.findAll(),employees2);
        Employee employee3 = new Employee("3", 100);
        employees.add(employee3);
        assertFalse(employeeInMemoryRepository.findAll().equals(employees2));
        //System.out.println(employees);
        //System.out.println(employees2);
    }

    @Test
    public void saveTest(){
        List<Employee> employees2= new ArrayList<Employee>();
        employees2.add(employee1);
        //System.out.println(employees2);
        assertEquals(employeeInMemoryRepository.save(employee1),employee1);

        assertEquals(employees,employees2);
        //System.out.println(employees);
        employeeInMemoryRepository.save(employee2);
        assertFalse(employees.equals(employees2));
    }

}
