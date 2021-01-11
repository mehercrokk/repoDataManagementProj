import {ChangeDetectorRef, ElementRef, OnInit} from '@angular/core';
import {User} from '../../model/user';
import {Router} from '@angular/router';
import {AfficherTableServiceService} from '../../services/afficher-table-service.service';
import {TableEntity} from '../../model/TableEntity';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import { Component } from '@angular/core';
import persons from './data-table-demo1-data';
import { DataTableResource } from 'angular7-data-table';
@Component({
  selector: 'app-afficher-table',
  templateUrl: './afficher-table.component.html',
  styleUrls: ['./afficher-table.component.css']
})
export class AfficherTableComponent  {
  user: TableEntity = new TableEntity();
  errorMessage: string;
  itemResource = new DataTableResource(persons);
  items = [];
  itemCount = 0;
  limits = [10, 20, 40, 80];

  constructor(private cdRef: ChangeDetectorRef, private afficherTableServiceService: AfficherTableServiceService, private router: Router) {
     this.itemResource.count().then(count => this.itemCount = count);
  }

  // findAllUsers(){
  //   this.authService.findAllUsers().subscribe(data => {
  //     this.userList = data;
  //     this.dataSource.data = data;
  //   });
  // }
  // @HostListener('input') oninput() {
  //   this.mdbTablePagination.searchText = this.searchText;
  // }


  reloadItems(params) {
    this.itemResource.query(params).then(items => this.items = items);
  }

  // special properties:
  rowClick(rowEvent) {
    console.log('Clicked: ' + rowEvent.row.item.name);
  }

  rowDoubleClick(rowEvent) {
    alert('Double clicked: ' + rowEvent.row.item.name);
  }

  rowTooltip(item) {
    return item.jobTitle;
  }
  affichertable() {
    this.afficherTableServiceService.affichertable(this.user).subscribe(data => {
     this.itemResource = data;
      // this.router.navigate(['/profile']);
    }, err => {
      this.errorMessage = 'Username or password is incorrect';
    });
  }

}
