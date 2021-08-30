import { LancamentoNota } from './../model/lancamentoNota.model';
import { Aluno } from './../../aluno/model/aluno.model';
import { AlunoService } from './../../aluno/aluno.service';
import { AnoBimestreService } from './../../anoBimestre/ano-bimestre.service';
import { LancamentoNotaService } from './../lancamentoNota.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AnoBimestre } from 'src/app/anoBimestre/model/anoBimestre.model';

@Component({
  selector: 'app-lancamento-nota-form',
  templateUrl: './lancamento-nota-form.component.html',
  styleUrls: ['./lancamento-nota-form.component.css']
})
export class LancamentoNotaFormComponent implements OnInit {

  formulario!: FormGroup;
  bimestres: AnoBimestre[] = [];
  alunos: Aluno[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private lancamentoNotaService: LancamentoNotaService,
    private anoBimestreService: AnoBimestreService,
    private alunoService: AlunoService,
    private router: Router) { }

  ngOnInit(): void {
    this.alunoService.findAll().subscribe(resposta => this.alunos = resposta);
    this.montarFormulario();
  }

  montarFormulario() {
    this.formulario = this.formBuilder.group({
      aluno: [null, Validators.required],
      ano: [null, Validators.required],
      bimestre: [null, Validators.required],
      faltas: [null, [Validators.required, Validators.max(40)]],
      participacaoSala: [null, [Validators.required, Validators.max(1.5)]],
      entregaTarefas: [null, [Validators.required, Validators.max(2.5)]],
      trabalhoBimestral: [null, [Validators.required, Validators.max(3)]],
      provaBimestral: [null, [Validators.required, Validators.max(3)]]
    })
  }

  onChangeCampoAno() {
    if (this.formulario.value.ano != null) {
      this.anoBimestreService
        .findAllByAno(this.formulario.value.ano)
        .subscribe(
          resposta => this.bimestres = resposta)
    }
  }

  submit() {
    if (this.formulario.valid) {
      const formValues = this.formulario.value;
      const lancamentoNota: LancamentoNota = new LancamentoNota(formValues.aluno, formValues.faltas, formValues.participacaoSala,
        formValues.entregaTarefas, formValues.trabalhoBimestral, formValues.provaBimestral, formValues.bimestre);

      this.lancamentoNotaService.salvar(lancamentoNota).subscribe(resposta => {
        this.lancamentoNotaService.showMessage("Lançamento de Nota Realizado com Sucesso!");
        this.router.navigate(['lancamentoNota/lancamentoNotaLista']);
      });
      this.formulario.reset();
    }

  }

  cancel() {
    this.router.navigate(['lancamentoNota/lancamentoNotaLista']);
  }

  get ano(): FormControl {
    return this.formulario.get('ano') as FormControl;
  }

  get participacaoSala(): FormControl {
    return this.formulario.get('participacaoSala') as FormControl;
  }

  get entregaTarefas(): FormControl {
    return this.formulario.get('entregaTarefas') as FormControl;
  }

  get trabalhoBimestral(): FormControl {
    return this.formulario.get('trabalhoBimestral') as FormControl;
  }

  get provaBimestral(): FormControl {
    return this.formulario.get('provaBimestral') as FormControl;
  }

  get bimestre(): FormControl {
    return this.formulario.get('bimestre') as FormControl;
  }

  get aluno(): FormControl {
    return this.formulario.get('aluno') as FormControl;
  }

  get faltas(): FormControl {
    return this.formulario.get('faltas') as FormControl;
  }


}
