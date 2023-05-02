import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable()
export class HTTPService {

  private http: HttpClient;

  constructor(http: HttpClient){
    this.http = http;
  }


  fetchProducts() {

    return this.http.get('http://localhost:8080/products')
    .pipe(map((response: any) => {
      const data = response;
      const products = data.map((prods) =>{
        return {name: prods.productName, price: prods.price, brand: prods.brand.brandName, category: prods.category.categoryName, productPreviewList: prods.productPreviewList}
      })
      console.log(products);
      return products;
    }));

  }

  fetchCategories(){
    return this.http.get('http://localhost:8080/categories')
    .pipe(map((response: any) => {
      const data = response;
      const categories = data.map((cgs) => {
        return {categoryName: cgs.categoryName}
      })
      return categories;
    }));
  }

  fetchBrands(){
    return this.http.get('http://localhost:8080/brands')
    .pipe(map((response: any) => {
      const data = response;
      const brands = data.map((brands) => {
        return {brandName: brands.brandName}
      })
      return brands;
    }));
  }








}
