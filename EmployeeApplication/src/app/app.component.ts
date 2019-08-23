import { Component, OnInit } from '@angular/core';
import { ServiceService } from './service.service';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { Employee } from './models/Employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'EmployeeApplication';
  public employees;
  constructor(private _service:ServiceService,private router:Router){}
  ngOnInit(){
      console.log("b4");
      this._service.getListOfEmployees().subscribe(data => {
        console.log("live:"+data);
        this.employees = data;
        console.log("live:"+this.employees[0].firstName);
      });
  }
  getEmployeeDetails(employee){
    //alert(employee.id);
    this._service.changeEmployeeId(employee.id);
    //this._service.getEmployeeDetails(employee.id);
    //this.employee.next(this.router.navigate(['/getEmployeeDetails', employee.id]));
    return this.router.navigate(['/getEmployeeDetails', employee.id]);
  }
}
