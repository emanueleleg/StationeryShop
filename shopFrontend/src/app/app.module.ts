import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { HTTPService } from './http.service';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HTTPService],
  bootstrap: [AppComponent]
})
export class AppModule { }
