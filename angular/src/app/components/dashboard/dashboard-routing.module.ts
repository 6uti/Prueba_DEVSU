import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { ClientesComponent } from './clientes/clientes.component';
import { CuentasComponent } from './cuentas/cuentas.component';
import { MovimientosComponent } from './movimientos/movimientos.component';
import { ReportesComponent } from './reportes/reportes.component';
import { CrearClienteComponent } from './clientes/crear-cliente/crear-cliente.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ActualizarClienteComponent } from './clientes/actualizar-cliente/actualizar-cliente.component';
import { CrearCuentaComponent } from './cuentas/crear-cuenta/crear-cuenta.component';
import { ActualizarCuentaComponent } from './cuentas/actualizar-cuenta/actualizar-cuenta.component';


const routes: Routes = [
  {path:'', component:DashboardComponent, children:[
    {path:'clientes', component: ClientesComponent},
    {path:'cuentas', component: CuentasComponent},
    {path:'movimientos', component: MovimientosComponent},
    {path:'reportes', component: ReportesComponent},
    {path: 'crear-cliente', component: CrearClienteComponent},
    {path: 'actualizar-cliente', component: ActualizarClienteComponent},
    {path: 'crear-cuenta', component: CrearCuentaComponent},
    {path: 'actualizar-cuenta', component: ActualizarCuentaComponent}
  ]}
];

@NgModule({
  imports: [ReactiveFormsModule,RouterModule.forChild(routes)],
  exports: [RouterModule,ReactiveFormsModule]
})
export class DashboardRoutingModule { }
