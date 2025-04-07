package com.example.rest.service.impl_services;

import com.example.rest.exceptions.AlreadyExistsException;
import com.example.rest.exceptions.ModelNotFoundException;
import com.example.rest.model.User;
import com.example.rest.repository.UserRepository;
import com.example.rest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl extends AbstractUnitedModelServiceImpl<User, UUID, UserRepository> implements UserService {


    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new ModelNotFoundException(
                        MessageFormat.format("User with name {0} not found!", username)
                ));
    }


    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                    .orElseThrow(() -> new ModelNotFoundException(
                            MessageFormat.format("User with email {0} not found!", email)
                    ));
        }


    @Override
    protected User updateFields(User oldUser, User newUser) {
        if (!Objects.equals(oldUser.getUsername(), newUser.getUsername()) && existsByUsername(newUser.getUsername())) {
            throw new AlreadyExistsException(
                    MessageFormat.format("User with username {0} already exists!",  newUser.getUsername())
            );
        } else if (!Objects.equals(oldUser.getUsername(), newUser.getUsername())) {
            oldUser.setUsername(newUser.getUsername());
        }

        if (!Objects.equals(oldUser.getEmail(), newUser.getEmail()) && existsByEmail(newUser.getEmail())) {
            throw new AlreadyExistsException(
                    MessageFormat.format("User with email {0} already exists!",  newUser.getUsername())
            );
        } else if (!Objects.equals(oldUser.getEmail(), newUser.getEmail())) {
            oldUser.setEmail(newUser.getEmail());
        }

        return oldUser;
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User save(User entity) {
        return super.save(entity);
    }



}