package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entites.Department;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("\n=== TEST 3: insert =======");
        Department dep2 = new Department(null, "Music");
        departmentDao.insert(dep2);
        System.out.println("Inserted! New id: " + dep2.getId());

        System.out.println("\n=== TEST 4: update =======");
        dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id = leia.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        leia.close();
    }
}
