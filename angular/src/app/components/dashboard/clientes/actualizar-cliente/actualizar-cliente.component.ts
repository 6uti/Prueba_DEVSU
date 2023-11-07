import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-actualizar-cliente',
  templateUrl: './actualizar-cliente.component.html',
  styleUrls: ['./actualizar-cliente.component.css']
})
export class ActualizarClienteComponent implements OnInit {
  formulario: FormGroup;

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
    var datosCliente = JSON.parse(localStorage.getItem("datosCliente")!);

    console.log("datosCliente",datosCliente);
    this.formulario.controls['nombres'].setValue(datosCliente.nombres);
    this.formulario.controls['edad'].setValue(datosCliente.edad);
    this.formulario.controls['telefono'].setValue(datosCliente.telefono);
    this.formulario.controls['genero'].setValue(datosCliente.genero);
    this.formulario.controls['direccion'].setValue(datosCliente.direccion);
    this.formulario.controls['contrasenia'].setValue(datosCliente.contrasenia);
    

  }

  

  actualizarCliente(){
    const valores = this.formulario.value; 
    var datosCliente = JSON.parse(localStorage.getItem("datosCliente")!);
    
    const body = {
      "contrasenia": valores.contrasenia,
      "estado": true,
      "persona": {
          "id":datosCliente.persona_id,
          "nombre": valores.nombres,
          "genero": valores.genero,
          "edad": valores.edad,
          "direccion": valores.direccion,
          "telefono": valores.telefono
      }
    };
    
    this.http.put<any>('http://localhost:8090/clientes/modificar/'+datosCliente.id, body)
        .subscribe({
            next: data => {
                //this.postId = data.id;
                console.log("",data);
                this.router.navigate(['/dashboard/clientes']);
            },
            error: error => {
                //this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });

  }

}
//