import java.util.List;

public interface EmployeeDao {
    Employee load(int id);

    List<Employee> getAll();

    void deleteEmployee(int id);

    Employee createEmployee(Employee employee);
}
