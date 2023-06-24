/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thao.repository;

import com.thao.HibernateUtils;
import com.thao.pojo.Product;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepository {
    public List<Product> getProducts(Map<String,String> params){
        try(Session s = HibernateUtils.getFactory().openSession()){
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            if(params != null){
                String kw = params.get("kw");
                if(kw != null && !kw.isEmpty()){
                    Predicate p = b.like(root.get("name"), String.format("%%%s%%", kw));
                    q.where(p);
                }
            }
            q.orderBy(b.desc(root.get("id")));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
}
