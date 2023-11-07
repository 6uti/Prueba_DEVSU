import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

//import { ClienteService } from 'src/app/services/clientes';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {
  formulario: FormGroup;
  
// private _clienteService: ClienteService,
  constructor(private fb:FormBuilder, private router:Router,private http: HttpClient){
    this.formulario = this.fb.group({
      nombres:['',Validators.required],
      edad:['',Validators.required],
      genero:['',Validators.required],
      telefono:['',Validators.required],
      direccion:['',Validators.required],
      contrasenia:['',Validators.required]
    })
  }

  ngOnInit(){
  }

  registrarCliente(){
    const valores = this.formulario.value; 
    
    const dato = {
      "contrasenia": valores.contrasenia,
      "estado": true,
      "persona": {
          "nombre": valores.nombres,
          "genero": valores.genero,
          "edad": valores.edad,
          "direccion": valores.direccion,
          "telefono": valores.telefono
      }
  };

    this.http.post<any>('http://localhost:8090/cuentas/guardar', dato).subscribe({
      next: data => {
          //this.postId = data.id;
          console.log("",data);
          this.router.navigate(['/dashboard/clientes']);

      },
      error: error => {
          //this.errorMessage = error.message;
          console.error('There was an error!', error);
      }
  })


  }

}
