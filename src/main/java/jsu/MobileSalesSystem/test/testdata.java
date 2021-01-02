package jsu.MobileSalesSystem.test;

import jsu.MobileSalesSystem.bean.Cart;
import jsu.MobileSalesSystem.bean.Phone;
import jsu.MobileSalesSystem.daoImpl.CartDaoImpl;
import jsu.MobileSalesSystem.daoImpl.PhoneDaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testdata {
    public static void main(String[] args) throws Exception {

//        PhoneDaoImpl p=new PhoneDaoImpl();
//      // Phone list= new Phone();
//         List list= new ArrayList();
//        list= (List) p.getAllphone();
//
//     // list= (Phone)p.findById(3);
//
//       // System.out.println(list);
//
//
//
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }


//        CartDaoImpl cartDao=new CartDaoImpl();
//        List list=new ArrayList();
//   list= cartDao.findAll("qwe");
//
//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        CartDaoImpl cartDao=new CartDaoImpl();
//        Cart cart=new Cart();
//        cart= CartDaoImpl.getCartId("qwe",5);
//        System.out.println(cart);


        CartDaoImpl cartDao=new CartDaoImpl();
        Cart cart=new Cart();
        //System.out.println( cartDao.Remove("qwe",4));
        boolean flag;
        flag=cartDao.Remove("user",3);
        System.out.println(flag);
        System.out.println("减肥第三发家史");
    }
}
