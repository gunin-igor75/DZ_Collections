package pro.sky.dz_collections.exeptions;

// Массив сотрудников переполнен

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
