package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");  //teste
        Seller seller = new Seller(21, "Juca", "jucamartins@email.com", new Date(), 2300.0,
                obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(seller);

    }
}
