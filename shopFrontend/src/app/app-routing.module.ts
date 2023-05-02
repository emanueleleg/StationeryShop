import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { ProductDetailsComponent } from "./product-details/product-details.component";
import { HomeComponent } from "./home/home.component";


const routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'products',
    component: DashboardComponent,
    data: {
      breadcrumb: [
        {
          label: 'Home',
          url: '',
          active: false,
          class: 'breadcrumb-item'
        },
        {
          label: 'Products',
          url: '/products',
          active: true,
          class: 'breadcrumb-item active'
        }
      ]
    }
  },
  {
    path: 'product-details',
    component: ProductDetailsComponent,
    data: {
      breadcrumb: [
        {
          label: 'Home',
          url: '',
          active: false,
          class: 'breadcrumb-item'
        },
        {
          label: 'Products',
          url: '/products',
          active: false,
          class: 'breadcrumb-item'
        },
        {
          label: 'Product-details',
          url: '/product-details',
          active: true,
          class: 'breadcrumb-item active'
        }
      ]
    }
  }
];







@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
