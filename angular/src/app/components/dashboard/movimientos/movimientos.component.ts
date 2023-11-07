import { Component, OnInit  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cuenta } from 'src/app/interfaces/cuenta';
import { Router } from '@angular/router';
import { Movimiento } from 'src/app/interfaces/movimiento';

@Component({
  selector: 'app-movimientos',
  templateUrl: './movimientos.component.html',
  styleUrls: ['./movimientos.component.css']
})
export class MovimientosComponent implements OnInit {
  
  listMovimientos: Movimiento[] = [];

  
  constructor(private http: HttpClient, private router:Router) { } // <---

  ngOnInit(): void {
    
    this.http.get<any>("http://localhost:8090/movimientos/todos").subscribe(data => {
      console.log("data",data);
      for (let item of data) {
        const movimiento: Movimiento = {
          id:item.id,
          fecha_movimiento:item.fecha_movimiento,
          tipo_movimiento:item.tipo_movimiento,
          valor:item.valor,
          saldo:item.saldo,
          cuenta_id:item.cuenta.id,
          numero_cuenta:item.cuenta.numero_cuenta,
          tipo_cuenta:item.cuenta.tipo_cuenta,
          saldo_inicial:item.cuenta.saldo_inicial,
          estado_cuenta:item.cuenta.estado};
        //console.log("cli",cli);
        this.listMovimientos.push( movimiento );
      }
   });
  }


  eliminarMovimiento(id: number){
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
  actualizarMovimiento(datos: any){
    //console.log("datos",datos);
    
    localStorage.setItem("datosCuenta", JSON.stringify(datos));
    this.router.navigate(['/dashboard/actualizar-cuenta']);
  }

}
