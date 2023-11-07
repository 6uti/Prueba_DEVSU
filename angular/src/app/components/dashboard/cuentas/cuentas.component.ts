import { Component, OnInit  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cuenta } from 'src/app/interfaces/cuenta';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent implements OnInit {
  
  listCuentas: Cuenta[] = [];

  
  constructor(private http: HttpClient, private router:Router) { } // <---

  ngOnInit(): void {
    
    this.http.get<any>("http://localhost:8090/cuentas/todos").subscribe(data => {
      console.log("data",data);
      for (let item of data) {
        const cuenta: Cuenta = {
          id:item.id,
          numero_cuenta:item.numero_cuenta,
          tipo_cuenta:item.tipo_cuenta,
          saldo_inicial:item.saldo_inicial,
          estado:item.estado,
          cliente_id:item.cliente.id,
          cliente_nombre:item.cliente.persona.nombre};
        //console.log("cli",cli);
        this.listCuentas.push( cuenta );
      }
   });
  }


  eliminarCuenta(id: number){
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
  actualizarCuenta(datos: any){
    //console.log("datos",datos);
    
    localStorage.setItem("datosCuenta", JSON.stringify(datos));
    this.router.navigate(['/dashboard/actualizar-cuenta']);
  }

}
