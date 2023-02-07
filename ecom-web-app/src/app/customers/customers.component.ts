import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Customer} from "./customer.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers: any;
  getOrdersDec: any;

  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.http.get<any>('http://localhost:9999/customer-service/customers?projection=fullCustomer').subscribe({
      next: (data) => {
        this.customers = data;
        console.log(this.customers);
      },
      error: (err) => {
      }
    });

  }
  getOrders(c){

    this.router.navigateByUrl('/orders/' + c.id);
  }

}
