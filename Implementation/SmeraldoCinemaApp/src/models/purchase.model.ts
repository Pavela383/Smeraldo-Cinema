import { ScreeningSeat } from '../models/screeningseat.model';


export class Purchase{
  
  public id : ScreeningSeat = null;
  public mail : string = "";
  public qrcode : string = "";
  
  constructor(obj?: any){
    this.set(obj);
  }

  set(obj?: any){
    if(obj){
      this.id = obj.id || this.id;
      this.mail = obj.mail || this.mail;
      this.qrcode = obj.qr_Code || this.qrcode;
    }
  }
  
}

