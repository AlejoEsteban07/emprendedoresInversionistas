package com.example.ejemploMinEnergia;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200" , maxAge = 3600)
@RestController
@RequestMapping("/ejemploMinEnegia")
public class Controller {
    
    @Autowired
    private EjemploFacade ejemploFacade;
    
    @GetMapping(value = "/consultaUsuario")
    public Emprendedor consultaUsuario(@RequestParam("usuario") String usuario,@RequestParam("clave") String clave){
        return ejemploFacade.consultaUsuario(usuario, clave);
    }
    
    @GetMapping(value = "/cargaInicialProductos")
    public ArrayList<Producto> cargaInicialProductos(){
        return ejemploFacade.cargaInicialProductos();
    }
    
    @GetMapping(value = "/consultaProductos")
    public ArrayList<Producto> consultaProductos(){
        return ejemploFacade.consultaProductos();
    }
    
    
    @GetMapping(value = "/agregarProducto")
    public void agregarProducto(@RequestParam("nombre") String nombre
                            ,@RequestParam("descripcion") String descripcion, @RequestParam("idEmprendedor") Integer idEmprendedor){
        ejemploFacade.agregarProducto(nombre, descripcion,idEmprendedor);
    }
    
    
    //Metodo que trae los productos de un emprendedor
    @GetMapping(value = "/consultaProductosPorEmprendedor")
    public ArrayList<Producto> consultaProductosPorEmprendedor(@RequestParam("idEmprendedor") Integer idEmprendedor){
        return ejemploFacade.consultaProductosEmprendedor(idEmprendedor);
    }
    
    //Metodo que trae elimina un producto
    @GetMapping(value = "/eliminarProducto")
    public ArrayList<Producto> eliminarProducto(@RequestParam("idProducto") Integer idProducto){
        return ejemploFacade.eliminarProducto(idProducto);
    }
    
    @PostMapping(value = "/crearEmprendedor")
    public void crearEmprendedor(@RequestBody Emprendedor emprendedor){
        ejemploFacade.crearEmprendedor(emprendedor);
    }
    
    //Metodo que trae modifica un producto
    @GetMapping(value = "/editarProducto")
    public ArrayList<Producto> modificarProducto(@RequestParam("idProducto") Integer idProducto,@RequestParam("nombreProducto") String nombreProducto,
                                                @RequestParam("descripcionProducto") String descripcionProducto){
        return ejemploFacade.editarProducto(idProducto,nombreProducto,descripcionProducto);
    }
    
}
