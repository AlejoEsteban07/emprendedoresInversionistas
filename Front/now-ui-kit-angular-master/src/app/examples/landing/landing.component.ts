import { Component, OnInit } from '@angular/core';
import { ConsultasService } from 'app/services/consultas.service';
import * as Rellax from 'rellax';

@Component({
  selector: 'app-landing',
  templateUrl: './landing.component.html',
  styleUrls: ['./landing.component.scss']
})
export class LandingComponent implements OnInit {
  data : Date = new Date();
  focus;
  focus1;

  datosCrearEmprendedor : dataEmprendedor;
  usuarioCorrecto : boolean;

  constructor(private service: ConsultasService) { }

  ngOnInit() {
    var body = document.getElementsByTagName('body')[0];
    body.classList.add('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.add('navbar-transparent');

    this.usuarioCorrecto = false;
  }
  ngOnDestroy(){
    var body = document.getElementsByTagName('body')[0];
    body.classList.remove('login-page');

    var navbar = document.getElementsByTagName('nav')[0];
    navbar.classList.remove('navbar-transparent');
  }

  registrarse(usuarioData,claveData,nombreData,correoData,celularData){

    this.datosCrearEmprendedor = {
      usuario : usuarioData,
      clave : claveData,
      nombre : nombreData,
      correo : correoData,
      celular : celularData
    }

    this.service.crearEmprendedor(this.datosCrearEmprendedor).subscribe(data=>{      
      console.log('dataUsuario Creado',data);
    })

    this.usuarioCorrecto = true;
  }
}

interface dataEmprendedor {
  usuario : string;
  clave : string;
  nombre : string;
  correo : string;
  celular : string;
}
