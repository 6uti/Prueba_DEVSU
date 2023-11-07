export interface Movimiento {
    id: number;
    fecha_movimiento: String;
    tipo_movimiento: number;
    valor: number;
    saldo: number;
    cuenta_id:number;
    numero_cuenta:String;
    tipo_cuenta:number;
    saldo_inicial:String;
    estado_cuenta:boolean;
  }