import { Component, OnInit } from '@angular/core';
import { HTTPService } from '../http.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  httpService: HTTPService;

  constructor(httpService: HTTPService) {
    this.httpService = httpService;
  }



  ngOnInit(): void {
    this.httpService.fetchProducts();
  }

}
