import { Component, OnInit } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Employee } from '../models/Employee';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  public employee = new Employee();
  public empId;
  constructor(private _service:ServiceService,
    private router: Router,
    private route:ActivatedRoute) { }

  ngOnInit() {
    this._service.empId.subscribe(id => {
      //const id = parseInt(data);
      //alert(id);
      this._service.getEmployeeDetails(id).subscribe((data: any) => {
        if (data) {
          this.employee = data;
        } else {
          console.log(`stock with id  not found, returning to list`);
          //this.redirectToStockList();
        }
      });

    });
    // let id = parseInt(this.route.snapshot.paramMap.get('id'));
    // this.empId = 1;
    // alert(this.empId);
    // this.route.params.subscribe(params =>{
    //   const id = params['id']
    //   alert(id);
    //   if(id){
    //     this._service.getEmployeeDetails(id).subscribe(data =>{
    //       this.employee = data;
    //     });
    //   }
    // });
  }

}
