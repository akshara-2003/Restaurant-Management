import { Component ,OnInit} from '@angular/core';
import { TableService } from '../table.service';
import {FormBuilder,FormGroup, Validators} from '@angular/forms'
// import {DatePipe} from '@angular/common'
@Component({
  selector: 'app-book-table',
  templateUrl: './book-table.component.html',
  styleUrls: ['./book-table.component.css']
})
export class BookTableComponent {
  reservationForm!:FormGroup;
    // startDateTime!:string;
    // endDateTime!:string;
    availableTables:any;
    reservation:any={customerName:'',bookingDateTime:'',isTableBooked:false}

    constructor(private tableService:TableService,private fb: FormBuilder){}
    ngOnInit(){
      this.reservationForm=this.fb.group({
       startDateTime:['',Validators.required],
       endDateTime:['',Validators.required]
      })
    }
    checkAvailability(){
      const startDateTime =this.reservationForm.get('startDateTime')?.value;
      const endDateTime = this.reservationForm.get('endDateTime')?.value;
      console.log(startDateTime);
      console.log(endDateTime);
      if(this.reservationForm.valid){
        this.tableService.getAvailableTables(startDateTime,endDateTime).
        subscribe((tables)=>{
          this.availableTables=tables;
        })
      }
    }
    // private formatDateTime(dateTime:string):string{
    //   const formattedDateTime  = this.datePipe.transform(new Date(dateTime),'yyyy-MM-ddTHH-mm:ss');
    //   return formattedDateTime||'';
    // }
    bookTable(tableId:string){
      this.reservation.bookingDateTime=this.reservationForm.get('startDateTime');
      // this.reservation.isTableBooked=true;

      this.tableService.bookTable(this.reservation).subscribe((bookedTable)=>{
        this.showBookedDetails(bookedTable);
        this.checkAvailability();
      })
    }
    private showBookedDetails(bookedTable:any){
      alert(`Table Booked!\n Table Number: ${bookedTable.tableNumber}\n Booking Time:${bookedTable.bookingDateTime}`)
    }
    releaseTable(reservationId:string){
      this.tableService.releaseTable(reservationId).subscribe(()=>{
        this.checkAvailability();
      })
    }
}
