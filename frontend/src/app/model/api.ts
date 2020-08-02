export class Api {

    model: string;
    age: number;
    anaemia: number;
    // tslint:disable-next-line: variable-name
    creatinine_phosphokinase: number;
    diabetes: number;
    // tslint:disable-next-line: variable-name
    ejection_fraction: number;
    // tslint:disable-next-line: variable-name
    high_blood_pressure: number;
    platelets: number;
    // tslint:disable-next-line: variable-name
    serum_creatinine: number;
    // tslint:disable-next-line: variable-name
    serum_sodium: number;
    sex: number;
    smoking: number;

}

export interface Deserializable {
    deserialize(input: any): this;
  }

export class Resultado implements Deserializable {

    confidence: number;
    category: number;
    credits: number;
    probability: number;

    deserialize(input: any) {
        Object.assign(this, input);
        return this;
      }

}
