import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/interfaces/cliente';

@Component({
  selector: 'app-crear-cuenta',
  templateUrl: './crear-cuenta.component.html',
  styleUrls: ['./crear-cuenta.component.css']
})
export class CrearCuentaComponent implements OnInit {
  formulario: FormGroup;
  listClientesSelect: Cliente[] = [];

  constructor(private fb:FormBuilder, private router:Router,private http: HttpClient){
    this.formulario = this.fb.group({
      numero_cuenta :['',Validators.required],
      tipo:['',Validators.required],
      saldo_inicial:['',Validators.required],
      cliente:['',Validators.required]
    })
  }

  registrarCuenta(){
    const valores = this.formulario.value; 
    console.log("valores",valores);

    const dato = {
      "numero_cuenta": valores.numero_cuenta,
      "tipo_cuenta":valores.tipo,
      "saldo_inicial":valores.saldo_inicial,
      "estado": true,
      "cliente": {
          "id": valores.cliente
      }
    };

    this.http.post<any>('http://localhost:8090/cuentas/guardar', dato).subscribe({
      next: data => {
          //this.postId = data.id;
          console.log("",data);
          this.router.navigate(['/dashboard/cuentas']);
      },
      error: error => {
          //this.errorMessage = error.message;
          console.error('There was an error!', error);
      }
    })
  }

  ngOnInit(){
    this.http.get<any>("http://localhost:8090/clientes/todos").subscribe(data => {
      for (let item of data) {
        const cli: Cliente = {id:item.id, nombres: item.persona.nombre,edad:item.persona.edad, direccion: item.persona.direccion,telefono: item.persona.telefono,contrasenia:item.contrasenia,estado:item.estado,genero: item.persona.genero,persona_id: item.persona.id};
        this.listClientesSelect.push( cli );
      }
    });

  }

}
