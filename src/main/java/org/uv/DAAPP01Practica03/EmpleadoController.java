package org.uv.DAAPP01Practica03;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository repositoryEmpleado;
    
    @GetMapping("/empleado/")
    public List<Empleado> list(){
        return repositoryEmpleado.findAll();
    }
    
    @GetMapping("/empleado/{id}")
    public Empleado get(@PathVariable Long id){
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if(optEmpleado.isPresent())
            return optEmpleado.get();
        else
            return null;
    }
    
    @PostMapping("/empleado/")
    public Empleado create(@RequestBody Empleado empleado){
        return repositoryEmpleado.save(empleado);
    }
    
    @PutMapping("/empleado/{id}")
    public Empleado update(@PathVariable Long id, @RequestBody Empleado empleadoDetails){
        Optional<Empleado> optEmpleado = repositoryEmpleado.findById(id);
        if(optEmpleado.isPresent()){
            Empleado empleado = optEmpleado.get();
            empleado.setNombre(empleadoDetails.getNombre());
            empleado.setDireccion(empleadoDetails.getDireccion());
            empleado.setTelefono(empleadoDetails.getTelefono());
            return repositoryEmpleado.save(empleado);
        } else {
            return null; 
        }
    }
    
    @DeleteMapping("/empleado/{id}")
    public void delete(@PathVariable Long id){
        repositoryEmpleado.deleteById(id);
    }
}
