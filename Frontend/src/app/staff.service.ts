import { Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private apiUrl ='http://localhost:8080/staff';
  constructor(private http:HttpClient){}
  getStaff(){
    return this.http.get<any>(`${this.apiUrl}`);
  }
  editStaff(staff:any){
    const editUrl = 'http://localhost:8080/api/staff'
    return this.http.put(`${editUrl}/editStaff/${staff.staffId}`,staff);
  }
}
