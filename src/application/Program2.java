package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department departmento;
        List<Department> list = departmentDao.findAll();

        System.out.println("\n==== TEST 1 : department insert  =====");
        System.out.println("\n Digite 1 para inserir um novo departamento ou qualquer outro número para pular esse teste: ");
        int digito = scan.nextInt();;
        if(digito == 1){
            System.out.println("Digite o nome do departamento a ser inserido: ");
            String nomeDepart = scan.nextLine();
            departmento = new Department(null, nomeDepart);
            departmentDao.insert(departmento);
            for (Department obj : list){
                System.out.println(obj);
            }
        }

        System.out.println("\n==== TEST 2 : department FindAll  =====");
        System.out.println("Clique ENTER");
        scan.nextLine();
        scan.nextLine();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3 : seller update  =====");
        System.out.println("Digite o Id do Departamento: ");
        int idDepartment = scan.nextInt();
        departmento = departmentDao.findById(idDepartment);
        if (departmento != null) {
            System.out.println("Digite o novo nome do Departamento: \n");
            scan.nextLine();
            String novoNome = scan.nextLine();
            departmento.setName(novoNome);
            departmentDao.update(departmento);
            System.out.println("Update Completed!");
            System.out.println("New update register is : " + departmentDao.findById(departmento.getId()));
        }
    }
}
