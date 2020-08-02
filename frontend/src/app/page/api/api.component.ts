import { Component, OnInit } from '@angular/core';
import { Api } from '../../model/api';
import { ConsumoService } from '../../service/consumo.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-api',
  templateUrl: './api.component.html',
  styleUrls: ['./api.component.css']
})
export class ApiComponent implements OnInit {

  api = new Api();
  constructor(private servicio: ConsumoService) { }

  ngOnInit(): void {
  }

  onSubmit(f: NgForm) {
    this.enviar(this.api, f);
  }

  enviar(body: Api, f: NgForm) {
    this.servicio.predecir(body);
    f.reset();
  }

}
