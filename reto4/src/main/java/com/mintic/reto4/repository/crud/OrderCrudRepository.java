package com.mintic.reto4.repository.crud;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mintic.reto4.model.Order;


public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    List<Order> findBySalesManZone(String zone);
    List<Order> findBySalesManId(Integer id);
    List<Order> findBySalesManIdAndStatus(Integer id, String status);
    List<Order> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
