package mk.ukim.finki.bazi.is_fagus.repository;


import mk.ukim.finki.bazi.is_fagus.model.Mebel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FurnitureJpaRepository extends JpaRepository<Mebel,Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD,attributePaths = {"evidencijaSeOdnesuvaNaMebels"})
    @Query("select m from Mebel m")
    List<Mebel> findAll();


}
