import { Component, Inject, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent {

  breadcrumbArray: any;

  constructor(private route: Router) { }

  ngOnInit(): void {
    this.route.events.subscribe(event => {
      if(event instanceof NavigationEnd){
        var snapshot = this.route.routerState.snapshot;
        this.breadcrumbArray = snapshot.root.children[0].data.breadcrumb;
      }

    })
  }

}
