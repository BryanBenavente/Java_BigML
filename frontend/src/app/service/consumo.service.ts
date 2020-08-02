import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Api } from '../model/api';

@Injectable({
  providedIn: 'root'
})
export class ConsumoService {

  api = environment.apiSrpring;

  constructor(private http: HttpClient) { }

  public predecir(data: Api) {
    const myHeaders = new Headers();
    myHeaders.append('Content-Type', 'application/json');
    const raw = JSON.stringify(data);
    let requestOptions;
    requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    return fetch(this.api + 'add', requestOptions);
  }

}
