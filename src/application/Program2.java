package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n==== TEST 1 : department insert  =====");
        System.out.println("Digite o nome do departamento a ser inserido: ");
        String nomeDepart = scan.nextLine();
        Department departmento = new Department(null, nomeDepart);
        departmentDao.insert(departmento);
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }


        System.out.println("\n==== TEST 2 : department FindAll  =====");
        System.out.println("Clique ENTER");
        for (Department obj : list){
            System.out.println(obj);
        }
    }
}
