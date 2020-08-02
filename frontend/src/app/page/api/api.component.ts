import { Component, OnInit } from '@angular/core';
import { Api, Resultado } from '../../model/api';
import { ConsumoService } from '../../service/consumo.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-api',
  templateUrl: './api.component.html',
  styleUrls: ['./api.component.css']
})
export class ApiComponent implements OnInit {

  api = new Api();
  result: Resultado;
  estado = false;

  // Resultado
  category: number;
  confidence: number;
  probability: number;
  credits: number;
  valor: string;

  constructor(private servicio: ConsumoService) { }

  ngOnInit(): void {
  }

  onSubmit(f: NgForm) {
    this.enviar(this.api, f);
  }

  enviar(body: Api, f: NgForm) {
    this.estado = false;
    this.servicio.predecir(body).subscribe(data => {
      console.log(data);
      this.genera(new Resultado().deserialize(data));
    });
    f.reset();
  }

  genera(data: Resultado) {
    this.estado = true;
    this.result = data;
    this.category = this.result.category;
    this.confidence = this.result.confidence;
    this.probability = this.result.probability;
    this.credits = this.result.credits;
    if (this.category === 1) {
      this.valor = 'Lo sentimos existe nuestro algoritmo nos dice que usted tiene los días contados :(';
    } else {
      this.valor = 'En hora buena, aun no hes momento de despedirnos :)';
    }
  }

}
