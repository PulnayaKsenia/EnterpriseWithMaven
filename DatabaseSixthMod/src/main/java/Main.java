
public class Main {
    public static void main(String[] args) {
        JdbcEmployeeDao employeeDao = new JdbcEmployeeDao();

        System.out.println("All employees");
        employeeDao.getAll().forEach(System.out::println);

        System.out.println("Employee with id = 3: " + employeeDao.load(3));
    }
}
