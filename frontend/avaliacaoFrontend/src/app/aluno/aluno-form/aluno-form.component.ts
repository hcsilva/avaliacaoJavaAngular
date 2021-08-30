import { AlunoService } from './../aluno.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Aluno } from '../model/aluno.model';

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  styleUrls: ['./aluno-form.component.css']
})
export class AlunoFormComponent implements OnInit {

  formulario!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private alunoService: AlunoService,
    private router: Router) { }

  ngOnInit(): void {
    this.montarFormulario();
  }

  montarFormulario() {
    this.formulario = this.formBuilder.group({
      nome: ['', Validators.required],
      situacao: new FormControl({ value: 'NÃO CALCULADO', disabled: true})
    })
  }

  submit() {
    if (this.formulario.valid) {
      const formValues = this.formulario.value;
      const aluno: Aluno = new Aluno(formValues.nome, 'NÃO CALCULADO');

      this.alunoService.salvar(aluno).subscribe(resposta => {
        this.alunoService.showMessage("Aluno Criado");
        this.router.navigate(['aluno/alunoLista']);
      });
      this.formulario.reset();
    }
  }

  cancel() {
    this.router.navigate(['aluno/alunoLista']);
  }

  get nome(): FormControl {
    return this.formulario.get('nome') as FormControl;
  }

}
