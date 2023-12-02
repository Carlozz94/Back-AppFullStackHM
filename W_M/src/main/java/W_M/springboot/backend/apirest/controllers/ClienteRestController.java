package W_M.springboot.backend.apirest.controllers;

import W_M.springboot.backend.apirest.models.entity.Cliente;
import W_M.springboot.backend.apirest.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    //metodo GetMapping para listar clientes
    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    //metodo GetMapping para mostrar un cliente
    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id){
        return clienteService.findById(id);
    }

    //metodo PostMapping para crear un cliente
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    //metodo PutMapping para actualizar un cliente
    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public  Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteActual = clienteService.findById(id);
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());
        return clienteService.save(clienteActual);
    }

    //metodo DeleteMapping para eliminar un cliente
    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.delete(id);
    }
}
