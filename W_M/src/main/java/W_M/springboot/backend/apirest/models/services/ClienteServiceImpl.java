package W_M.springboot.backend.apirest.models.services;

import W_M.springboot.backend.apirest.models.dao.IClienteDao;
import W_M.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        List<Cliente> clients = (List<Cliente>) clienteDao.findAll();
            return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {

        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {

        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        clienteDao.deleteById(id);

    }
}
