
package com.example.ejemploMinEnergia;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class EjemploFacade {
    
    ArrayList<Producto> listadoProductos = new ArrayList<Producto>();
    ArrayList<Emprendedor> listadoEmprendedores = new ArrayList<Emprendedor>();
       
    public Emprendedor consultaUsuario(String usuario, String clave){
       Emprendedor emprendedor = new Emprendedor();
       emprendedor.setIdEmprendedor(0);
       int respuesta = 0;
       if(listadoEmprendedores.size()>0){
           for(int i= 0; i<listadoEmprendedores.size();i++){
               if(listadoEmprendedores.get(i).getUsuario().equals(usuario) 
                       && listadoEmprendedores.get(i).getClave().equals(clave)){
                   emprendedor = listadoEmprendedores.get(i);
                   break;
               }
           }
       }
       return emprendedor;
    }
    
    public ArrayList<Producto> cargaInicialProductos(){
        listadoProductos = new ArrayList<Producto>();
        Producto producto1 = new Producto();
        producto1.setIdProducto(1);
        producto1.setNombre("Producto 1");
        producto1.setDescripcion("Aqui encontraras la descripción de nuestro producto numero 1");
        listadoProductos.add(producto1);
        
        Producto producto2 = new Producto();
        producto2.setIdProducto(2);
        producto2.setNombre("Producto 2");
        producto2.setDescripcion("Aqui encontraras la descripción de nuestro producto numero 2");
        listadoProductos.add(producto2);
        
        return listadoProductos;
        
    }
    
    public ArrayList<Producto> consultaProductos(){        
        return listadoProductos;        
    }
    
    
    public void agregarProducto(String nombre, String descripcion, Integer idEmprendedor){
        int idProducto;
        if(listadoProductos.size() == 0 ){
            idProducto = 1;
        }else{
            idProducto = listadoProductos.size() +1;
        }
        
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setIdEmprenderdor(idEmprendedor);
        listadoProductos.add(producto);
        System.out.println(listadoProductos);
    }
    
    public ArrayList<Producto> consultaProductosEmprendedor(Integer idEmprendedor){ 
        ArrayList<Producto> listadoProductosEmprendedor = new ArrayList<Producto>();
        for(int i=0;i<listadoProductos.size();i++){
            if(listadoProductos.get(i).getIdEmprenderdor()== idEmprendedor){
                listadoProductosEmprendedor.add(listadoProductos.get(i));
            }
        }
        return listadoProductosEmprendedor;        
    }
    
    
    public void crearEmprendedor(Emprendedor emprendedor){
        Emprendedor nuevoEmprendedor = new Emprendedor();
        int idEmprendedor;
        if(listadoEmprendedores.size() == 0 ){
            idEmprendedor = 1;
        }else{
            idEmprendedor = listadoEmprendedores.size() +1;
        }
        nuevoEmprendedor.setIdEmprendedor(idEmprendedor);
        nuevoEmprendedor.setUsuario(emprendedor.getUsuario());
        nuevoEmprendedor.setClave(emprendedor.getClave());
        nuevoEmprendedor.setNombre(emprendedor.getNombre());
        nuevoEmprendedor.setCorreo(emprendedor.getCorreo());
        nuevoEmprendedor.setCelular(emprendedor.getCelular());
        
        listadoEmprendedores.add(nuevoEmprendedor);
        
    }
    
    public ArrayList<Producto> eliminarProducto(Integer idProducto){
       for(int i= 0;i<listadoProductos.size();i++){
           if(listadoProductos.get(i).getIdProducto() == idProducto){
               listadoProductos.remove(i);
           }
       }
       
       return listadoProductos;
    }
    
    public ArrayList<Producto> editarProducto(Integer idProducto, String nombreProducto, String descripcionProducto){
        Producto editarProducto = new Producto();
        if(listadoProductos.size() != 0 ){
            for(int i=0; i<listadoProductos.size();i++){
                if(listadoProductos.get(i).getIdProducto() == idProducto){
                    editarProducto.setIdProducto(idProducto);
                    editarProducto.setNombre(nombreProducto);
                    editarProducto.setDescripcion(descripcionProducto);
                    listadoProductos.set(i, editarProducto);
                }
            }
        }        
        return listadoProductos;
    }
    
    
    
}
