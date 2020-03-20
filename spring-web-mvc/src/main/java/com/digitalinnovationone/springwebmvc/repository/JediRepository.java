package com.digitalinnovationone.springwebmvc.repository;

import com.digitalinnovationone.springwebmvc.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long> {
    List<Jedi> findByNameContainingIgnoreCase(final String name);
}
//public class JediRepository {
//    private List<Jedi> jediList;
//
//    public JediRepository() {
//        jediList = new ArrayList<>();
//        jediList.add(new Jedi("Luke", "Skywalker"));
//    }
//
//    public List<Jedi> getAllJedi() {
//        return this.jediList;
//    }
//
//    public void add(Jedi jedi) {
//        this.jediList.add(jedi);
//    }
//}
