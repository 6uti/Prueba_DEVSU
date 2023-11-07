import { Component, OnInit  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from 'src/app/interfaces/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  listClientes: Cliente[] = [];

  constructor(private http: HttpClient, private router:Router) { } // <---

  ngOnInit(): void {
    
    this.http.get<any>("http://localhost:8090/clientes/todos").subscribe(data => {
      for (let item of data) {
        const cli: Cliente = {id:item.id, nombres: item.persona.nombre,edad:item.persona.edad, direccion: item.persona.direccion,telefono: item.persona.telefono,contrasenia:item.contrasenia,estado:item.estado,genero: item.persona.genero,persona_id: item.persona.id};
        console.log("cli",cli);
        this.listClientes.push( cli );
      }
   });
  }

  eliminarCliente(id: number){
    console.log(id);

    this.http.delete('http://localhost:8090/clientes/eliminar/'+id)
        .subscribe({
            next: data => {
              console.log("data",data);
                //this.status = 'Delete successful';
            },
            error: error => {
                //this.errorMessage = error.message;
                console.error('There was an error!', error);
            }
        });

  }
  actualizarCliente(datos: any){
    //console.log("datos",datos);
    
    localStorage.setItem("datosCliente", JSON.stringify(datos));
    this.router.navigate(['/dashboard/actualizar-cliente']);
  }

}
