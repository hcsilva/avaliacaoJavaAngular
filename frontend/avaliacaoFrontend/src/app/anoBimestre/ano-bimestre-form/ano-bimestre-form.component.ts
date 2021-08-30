import { AnoBimestreService } from './../ano-bimestre.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl, MaxLengthValidator } from '@angular/forms';
import { Router } from '@angular/router';
import { AnoBimestre } from '../model/anoBimestre.model';

@Component({
  selector: 'app-ano-bimestre-form',
  templateUrl: './ano-bimestre-form.component.html',
  styleUrls: ['./ano-bimestre-form.component.css']
})
export class AnoBimestreFormComponent implements OnInit {

  formulario!: FormGroup;
  bimestres: AnoBimestre[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private anoBimestreService: AnoBimestreService,
    private router: Router) { }

  ngOnInit(): void {
    this.montarFormulario();
  }

  montarFormulario() {
    this.formulario = this.formBuilder.group({
      ano: ['', Validators.required],
    })
  }

  submit() {
    if (this.formulario.valid) {
      const formValues = this.formulario.value;
      this.anoBimestreService
        .findAllByAno(formValues.ano)
        .subscribe(
          resposta => resposta.length > 0 ? this.anoBimestreService.showMessage("Bimestres Já Gerados para o ano em questão!") :

            this.anoBimestreService.gerarBimestres(formValues.ano).subscribe(resposta => {
              this.anoBimestreService.showMessage("Bimestres Gerados com sucesso!");
              this.router.navigate(['anoBimestre/anoBimestreLista']);
              this.formulario.reset();
            })
        )
    }
  }

  cancel() {
    this.router.navigate(['anoBimestre/anoBimestreLista']);
  }

  get ano(): FormControl {
    return this.formulario.get('ano') as FormControl;
  }


}
