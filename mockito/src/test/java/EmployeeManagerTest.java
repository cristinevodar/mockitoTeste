import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.mockito.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.*;

import static org.mockito.Mockito.*;

public class EmployeeManagerTest {
    private EmployeeManager underTest;
    private EmployeeRepository employeeRepository=mock(EmployeeRepository.class);
    private BankService bankService=mock(BankService.class);
    List<Employee> employees2;
    private Employee employee;

    @BeforeEach
    void setUp(){
        underTest=new EmployeeManager(employeeRepository,bankService);
        List<Employee> employees2= new ArrayList<Employee>();
        employee = new Employee("2", 750.10);
        employees2.add(employee);
    }

    @Test
    public void shouldPayEmployees()
    {
        when(employeeRepository.findAll())
                .thenReturn(employees2);
        doNothing().when(bankService).pay(isA(String.class), isA(Double.class));
        int a=underTest.payEmployees();
        System.out.println(a);
        //assertEquals(underTest.payEmployees(),0);
    }
}


