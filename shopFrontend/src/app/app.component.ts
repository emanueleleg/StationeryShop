import { Component, OnInit } from '@angular/core';
import { HTTPService } from './http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  httpService: HTTPService;

  constructor(httpService: HTTPService){
    this.httpService = httpService;
  }

  ngOnInit(): void {
    this.httpService.fetchProducts();
  }




}
