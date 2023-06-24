/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.thao;

import com.thao.pojo.Category;
import com.thao.repository.ProductRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ComThao {

    public static void main(String[] args) {
        Map<String,String> params = new HashMap<>();
        params.put("kw", "iphone");
        
        ProductRepository r = new ProductRepository();
        r.getProducts(params).forEach(p -> System.out.printf("%d - %s - %.1f\n", p.getId(), p.getName(), p.getPrice()));
//        try(Session s = HibernateUtils.getFactory().openSession()){
//            Query q = s.createQuery("FROM Category");
//            List<Category> cates = q.getResultList();
//            cates.forEach(c -> System.out.println(c.getName()));
//        }
    }
}
