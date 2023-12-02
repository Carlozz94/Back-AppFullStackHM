package W_M.springboot.backend.apirest.models.dao;

import W_M.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository <Cliente, Long>{

}
