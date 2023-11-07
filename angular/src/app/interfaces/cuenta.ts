export interface Cuenta {
    id: number;
    numero_cuenta: String;
    tipo_cuenta: number;
    saldo_inicial: number;
    estado: boolean;
    cliente_id:number;
    cliente_nombre:String;
  }