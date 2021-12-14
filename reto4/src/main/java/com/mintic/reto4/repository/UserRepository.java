package com.mintic.reto4.repository;

import java.util.List;
import java.util.Optional;

import com.mintic.reto4.model.User;
import com.mintic.reto4.repository.crud.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userInterface;

    public List<User> getAll(){
        return userInterface.findAll();
    }

    public Optional<User> getUser(Integer id){
        return userInterface.findById(id);
    }

    public boolean ExisteEmail(String email){
        Optional<User> usuario = userInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUser(String email, String password){
        return userInterface.findByEmailAndPassword(email, password);
    }

    public User save(User user){
        return userInterface.save(user);
    }

    public void update(User user){
        userInterface.save(user);
    }

    public void delete(User user){
        userInterface.delete(user);
    }

}
