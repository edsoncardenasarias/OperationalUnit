export interface transactionDataCompleteResponse {
  funcionaryResponseDto: {
    id : number ;
    name : String ;
    director : String ;
    telephone : String ;
    address : String ;
    department : String ;
    active : String ;
  };

  teenResponseDto: {
    id_program :number ;
    name : String ;
    type : String ;
    beneficiary : String ;
    responsible : String ;
    description : String ;
    duration : number ;
    condition : String ;
  };

  transaccionalAllocation: {
    id_funcionaryteend: number;
    description: string;
    estado: string;
    id_program: number;
    id: number;
  };
}
