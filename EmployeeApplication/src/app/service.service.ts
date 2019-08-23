import { Injectable, Output } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Employee } from './models/Employee';
import { HttpClient } from '@angular/common/http';
import { EventEmitter } from 'events';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  public empployees:any;
  private URL = "http://localhost:8181";
  // @Output() emp = new EventEmitter();
  private employeeId = new BehaviorSubject(<Number>(1));
  empId = this.employeeId.asObservable();

  constructor(private httpClient:HttpClient) { }
  getListOfEmployees(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.URL+"/getEmployees");
  }
  getEmployeeDetails(id:Number): Observable<Employee> {
   // alert("adf");
    return this.httpClient.get<Employee>(this.URL+"/getEmployeeDetails/"+id);
  }
  changeEmployeeId(id){
    this.employeeId.next(id);
  }

}
