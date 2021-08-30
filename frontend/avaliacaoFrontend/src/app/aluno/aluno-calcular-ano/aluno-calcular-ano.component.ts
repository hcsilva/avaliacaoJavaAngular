import { AlunoService } from './../aluno.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Aluno } from '../model/aluno.model';


@Component({
  selector: 'app-aluno-calcular-ano',
  templateUrl: './aluno-calcular-ano.component.html',
  styleUrls: ['./aluno-calcular-ano.component.css']
})
export class AlunoCalcularAnoComponent implements OnInit {

  aluno: Aluno;
  campoSituacao: String;

  formulario = new FormGroup({
    ano: new FormControl(null, Validators.required),
  });

  constructor(
    private formBuilder: FormBuilder,
    private alunoService: AlunoService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.montarFormulario();
  }

  montarFormulario() {
    this.formulario = this.formBuilder.group({
      id: [null],
      ano: [null, Validators.required]
    })
  }

  submit() {
    if (this.formulario.valid) {
      const formValues = this.formulario.value;
      
      this.alunoService.realizarCalculoSituacaoAluno(formValues.ano, +this.activeRoute.snapshot.paramMap.get('id')!, this.formulario.value).subscribe(resposta => {
        this.alunoService.showMessage("Cálculo Realizado com Sucesso!");
        this.router.navigate(['aluno/alunoLista']);
      });
      this.formulario.reset();
    }
  }

  cancel() {
    this.router.navigate(['aluno/alunoLista']);
  }

  get ano(): FormControl {
    return this.formulario.get('ano') as FormControl;
  }
}
