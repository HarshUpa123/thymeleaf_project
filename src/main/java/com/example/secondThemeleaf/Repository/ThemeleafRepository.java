package com.example.secondThemeleaf.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.secondThemeleaf.Entity.ThemeleafEntity;
@Repository
public interface ThemeleafRepository extends JpaRepository<ThemeleafEntity, Integer> {

}
