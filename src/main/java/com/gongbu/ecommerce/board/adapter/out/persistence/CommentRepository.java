package com.gongbu.ecommerce.board.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentJpaEntity, Long> {
}
