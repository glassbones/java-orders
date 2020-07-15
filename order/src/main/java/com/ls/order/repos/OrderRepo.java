package com.ls.order.repos;
import com.ls.order.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> { }