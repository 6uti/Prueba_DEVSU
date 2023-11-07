import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/interfaces/cliente';

@Component({
  selector: 'app-actualizar-cuenta',
  templateUrl: './actualizar-cuenta.component.html',
  styleUrls: ['./actualizar-cuenta.component.css']
})
export class ActualizarCuentaComponent implements OnInit {
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

  ngOnInit(){

    this.http.get<any>("http://localhost:8090/clientes/todos").subscribe(data => {
      for (let item of data) {
        const cli: Cliente = {id:item.id, nombres: item.persona.nombre,edad:item.persona.edad, direccion: item.persona.direccion,telefono: item.persona.telefono,contrasenia:item.contrasenia,estado:item.estado,genero: item.persona.genero,persona_id: item.persona.id};
        this.listClientesSelect.push( cli );
      }
    });

    var datosCuenta = JSON.parse(localStorage.getItem("datosCuenta")!);

    console.log("datosCuenta",datosCuenta);
    this.formulario.controls['numero_cuenta'].setValue(datosCuenta.numero_cuenta);
    this.formulario.controls['tipo'].setValue(datosCuenta.tipo_cuenta);
    this.formulario.controls['saldo_inicial'].setValue(datosCuenta.saldo_inicial);
    this.formulario.controls['cliente'].setValue(datosCuenta.cliente_id);



    /*
    
    this.formulario.controls['edad'].setValue(datosCliente.edad);
    this.formulario.controls['telefono'].setValue(datosCliente.telefono);
    this.formulario.controls['genero'].setValue(datosCliente.genero);
    this.formulario.controls['direccion'].setValue(datosCliente.direccion);
    this.formulario.controls['contrasenia'].setValue(datosCliente.contrasenia);
    */

  }

  actualizarCuenta(){
  }

}
