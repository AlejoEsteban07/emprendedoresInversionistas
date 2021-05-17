import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {HttpParams } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class ConsultasService{

    constructor(private http:HttpClient){}

    urlBase='http://localhost:8080/ejemploMinEnegia';

    Url='http://localhost:8080/ejemploMinEnegia/consultaProductos';
    Urlusuario='http://localhost:8080/ejemploMinEnegia/consultaUsuario';
    UrlAgregarProducto='http://localhost:8080/ejemploMinEnegia/agregarProducto';

    getProductos() {
        return this.http.get(this.Url);
    }


    consultausuario(usuario, clave){
        const params = new HttpParams()
            .set('usuario', usuario.toString())
            .set('clave', clave.toString());
        return this.http.get(this.Urlusuario +'?'+'usuario=' + usuario +'&'+'clave='+clave);
    }

    agregarProducto(nombre,descripcion,idEmprendedor){
        return this.http.get(this.UrlAgregarProducto +'?'+'nombre='+nombre+'&'+'descripcion='+descripcion+'&'+'idEmprendedor='+idEmprendedor);

    }

    eliminarProducto(idProducto){
        const params = new HttpParams()
            .set('idProducto', idProducto.toString());
        return this.http.get(this.urlBase+'/eliminarProducto' +'?'+'idProducto=' + idProducto);
    }

    crearEmprendedor(object: any){
        return this.http.post(this.urlBase+'/crearEmprendedor',object)
    }

    editarProducto(idProd, nomProd, desProd){
        return this.http.get(this.urlBase+'/editarProducto' +'?'+'idProducto=' + idProd +'&'+'nombreProducto='+nomProd+'&'+'descripcionProducto='+desProd);
    }

}
