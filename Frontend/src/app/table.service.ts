import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TableService {
  private apiUrl = 'http://localhost:8080/api/tableReservations';
  constructor(private http:HttpClient) { }

  getAvailableTables(startDateTime: string,endDateTime:string){
    return this.http.get(`${this.apiUrl}/available`,{
      params : {startDateTime,endDateTime}
    });
  }

  bookTable(reservation:any){
    return this.http.post(`${this.apiUrl}/book`,reservation);
  }
  releaseTable(reservationId:string){
    return this.http.delete(`${this.apiUrl}/release/${reservationId}`);
  }
}
