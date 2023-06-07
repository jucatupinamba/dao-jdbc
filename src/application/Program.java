package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== TEST 1 : seller FindById  =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== TEST 2 : seller FindByDepartment  =====");
        System.out.println("Digite o número do departamento a ser buscado: departamento < 5");
        int dep = scan.nextInt();
        Department department = new Department(dep, null);
        scan.nextLine();
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3 : seller FindAll  =====");
        System.out.println("Clique ENTER");
        scan.nextLine();
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 4 : seller insert  =====");
        System.out.println("Digite o nome a ser inserido: ");
        String nome = scan.nextLine();
        System.out.println("Digite o email: ");
        String email = scan.nextLine();
        System.out.println("Digite o número do departamento: departamento <= 6");
        int depart = scan.nextInt();
        Department departmento = new Department(depart, null);
        Seller newSeller = new Seller(null, nome, email, new Date(), 3000.0, departmento);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        System.out.println("New register is : " + sellerDao.findById(newSeller.getId()));

        System.out.println("\n==== TEST 5 : seller update  =====");
        System.out.println("Digite o Id do Vendedor: id < 10");
        int idVendor = scan.nextInt();
        seller = sellerDao.findById(idVendor);
        if (seller != null) {
            System.out.println("Para simplificar o teste, pode atualizar apenas o nome. \n"
                + "Digite o nome: ");
            scan.nextLine();
            String novoNome = scan.nextLine();
            seller.setName(novoNome);
            sellerDao.update(seller);
            System.out.println("Update Completed!");
            System.out.println("New update register is : " + sellerDao.findById(seller.getId()));
        }

        System.out.println("\n==== TEST 6 : seller delete  =====");
        System.out.println("Digite o Id do funcionário que deseja deletar: ");
        int id = scan.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted completed! ");
        System.out.println();

        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        scan.close();


    }
}
