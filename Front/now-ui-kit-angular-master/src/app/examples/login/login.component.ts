import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ConsultasService } from 'app/services/consultas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    data : Date = new Date();
    focus;
    focus1;

    nombre : string;
    clave : string;

    formulario : FormGroup;
    usuarioCorrecto : boolean;
    dataUsuario : any;

    constructor(private service: ConsultasService, private router: Router) { }

    ngOnInit() {
        var body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.add('navbar-transparent');


        this.formulario = new FormGroup({
            nombreForm : new FormControl(),
            claveForm : new FormControl()
        });
        
        this.usuarioCorrecto = false;

    }
    ngOnDestroy(){
        var body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');

        var navbar = document.getElementsByTagName('nav')[0];
        navbar.classList.remove('navbar-transparent');
    }


    ingreso(usuario,claveUsu){
        this.service.consultausuario(usuario,claveUsu).subscribe(data=>{
            this.dataUsuario = data;
            if( this.dataUsuario.idEmprendedor == 0){
                this.usuarioCorrecto = true;
            }else{                
                this.router.navigate(["/examples/profile"],{queryParams:{nombre: this.dataUsuario.nombre}})
            }
            
            console.log('dataUsuario',data);
        })
    }


}
