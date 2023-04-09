package br.com.avanade.dio.apis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.avanade.dio.apis.dto.ClientDTO;
import br.com.avanade.dio.apis.exception.ApplicationException;
import br.com.avanade.dio.apis.form.ClientForm;
import br.com.avanade.dio.apis.form.LoginForm;

public interface ClientService {

    @Transactional
    ClientDTO createClient(ClientForm client);

    ClientDTO getClient(int id) throws ApplicationException;

    List<ClientDTO> getClients();
    
    ClientDTO createClient(LoginForm form);

}
