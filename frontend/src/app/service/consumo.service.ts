import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Api } from '../model/api';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsumoService {

  api = environment.apiSrpring;

  constructor(private http: HttpClient) { }

  public predecir(data: Api) {
    const raw = JSON.stringify(data);
    return this.http.post(`${this.api}add`, raw, {
      headers: new HttpHeaders({
           'Content-Type':  'application/json',
         })
    });
  }

}
