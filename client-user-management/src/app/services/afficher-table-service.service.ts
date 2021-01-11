import { Injectable } from '@angular/core';

import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

import {TableEntity} from '../model/TableEntity';

let API_URL = "http://localhost:8080/";

@Injectable({
  providedIn: 'root'
})
export class AfficherTableServiceService {

  constructor(private http: HttpClient) { }

  affichertable(user: TableEntity): Observable<any> {
    const headers = new HttpHeaders(user ? {
      authorization: 'Basic ' + btoa(user.user + ':' + user.password + ':' + user.nomtable)
    } : {});

    return this.http.get<any>(API_URL + "afficherTable" , {headers})
    .pipe( map (response => {
      if (response) {
        localStorage.setItem('currentUser', JSON.stringify(response));
      }
      return response;
    }));
  }
}
