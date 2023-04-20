import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { map } from 'rxjs';

@Injectable()
export class HTTPService {

  private http: HttpClient;

  constructor(http: HttpClient){
    this.http = http;
  }


  fetchProducts() {

    this.http.get('http://localhost:8080/products')
    .subscribe(
      (data) => {
        console.log(data);
      }
    );

  }



}
