package pro.sky.dz_collections.exeptions;

// Сотрудник не найден

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
