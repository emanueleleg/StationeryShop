import { Component, Input, OnInit } from '@angular/core';
import { HTTPService } from '../http.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


  products = [];
  productsBackup = [];
  categories = [];
  brands = [];
  httpService: HTTPService;
  priceSelected = 50;

  lastCategoryEvent = null;
  lastBrandEvent = null;

  constructor(httpService: HTTPService) {
    this.httpService = httpService;
  }


  /*
    todo:

      - Bisogna far funzionare i filtri in contemporanea.


      - Product Details
      - Home
  */
  onChange(event, filterName) {



    if(filterName == 'category'){
      console.log("e' category");
      if(this.lastCategoryEvent == null){

        console.log("e' nullo");
        this.lastCategoryEvent = event;
      }
      else if(this.lastCategoryEvent.target.name != event.target.name && (this.lastCategoryEvent.target.name.includes(filterName) === true)) {
        console.log("magia");
        this.lastCategoryEvent.target.checked = false;
        this.lastCategoryEvent = event;
      }
      else{
        this.lastCategoryEvent = event;
      }
    }
    else if(filterName == 'brand'){
      if(this.lastBrandEvent == null)
      this.lastBrandEvent = event;
      else if(this.lastBrandEvent.target.name != event.target.name && (this.lastBrandEvent.target.name.includes(filterName) === true)) {
        this.lastBrandEvent.target.checked = false;
        this.lastBrandEvent = event;
      }
      else{
        this.lastBrandEvent = event;
      }
    }


  }


  onPriceChange(event) {
    this.priceSelected = event.target.value;
    this.products = this.productsBackup.filter(p => p.price <= event.target.value);
  }

  onCheckInput(filterId, name, event) {


    if(filterId === 1) {
      if(event.target.checked == true){

        this.productsBackup
        .filter(p => p.category === name)
        .forEach((p) => {
          if(this.products.indexOf(p) === -1){
            this.products.push(p);
          }
        });


      }
      else {
        this.products = this.productsBackup.filter(p => p.category !== name);
      }

    }
    else {
      this.products = this.productsBackup;
      if(event.target.checked == true)
                this.productsBackup
        .filter(p => p.brand === name)
        .forEach((p) => {
          if(this.products.indexOf(p) === -1){
            this.products.push(p);
          }
        });
      else
        this.products = this.productsBackup.filter(p => p.brand !== name);
    }

  }



  ngOnInit(): void {
    this.httpService.fetchProducts()
    .subscribe(
      (data: any) => {
        this.products = data;
        this.productsBackup = this.products;
      }
    );

    this.httpService.fetchCategories()
    .subscribe(
      (data: any) => {
        this.categories = data;
      }
    );

    this.httpService.fetchBrands()
    .subscribe(
      (data: any) => {
        this.brands = data;
      }
    );

  }

}
