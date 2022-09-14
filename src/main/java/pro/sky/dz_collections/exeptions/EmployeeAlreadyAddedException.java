package pro.sky.dz_collections.exeptions;

//когда нового сотрудника пытаются добавить в массив, а в массиве уже есть такой сотрудник

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
