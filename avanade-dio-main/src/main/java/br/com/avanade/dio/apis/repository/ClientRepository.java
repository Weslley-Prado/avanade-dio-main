package br.com.avanade.dio.apis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.avanade.dio.apis.model.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    Optional<ClientModel> findByEmail(String username);

}
