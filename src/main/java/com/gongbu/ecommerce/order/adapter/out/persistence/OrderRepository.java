package com.gongbu.ecommerce.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderJpaEntity, Long> {
}
