import { AlunoService } from './../aluno.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Aluno } from '../model/aluno.model';

@Component({
  selector: 'app-aluno-editar',
  templateUrl: './aluno-editar.component.html',
  styleUrls: ['./aluno-editar.component.css']
})
export class AlunoEditarComponent implements OnInit {

  aluno: Aluno;
  campoSituacao: String;

  formulario = new FormGroup({
    nome: new FormControl(null, Validators.required),
    situacao: new FormControl({ value: null, disabled: true })
  });

  constructor(
    private formBuilder: FormBuilder,
    private alunoService: AlunoService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.activeRoute.snapshot.paramMap.get('id')!;
    this.alunoService.readById(id).subscribe((aluno: any) => {
      this.situacaoAluno(this.formulario.value.situacao);
      this.formulario = new FormGroup({
        nome: new FormControl(aluno['nome'], Validators.required),
        situacao: new FormControl({ value: this.campoSituacao, disabled: true })
      })
    });

    this.montarFormulario();
  }

  montarFormulario() {
    this.formulario = this.formBuilder.group({
      id: [null],
      nome: [null, Validators.required],
      situacao: [null]
    })
  }

  situacaoAluno(sit: string) {
    if (sit == 'N') {
      this.campoSituacao = 'Não Calculado';
      console.log(sit);
    }
  }

  updateData() {
    if (this.formulario.valid) {
      this.alunoService.update(+this.activeRoute.snapshot.paramMap.get('id')!, this.formulario.value).subscribe(() => {
        this.alunoService.showMessage("Aluno atualizado com sucesso!");
        this.router.navigate(['aluno/alunoLista']);
      });
    }
  }

  cancel() {
    this.router.navigate(['aluno/alunoLista']);
  }

  get nome(): FormControl {
    return this.formulario.get('nome') as FormControl;
  }

  get situacao(): FormControl {
    return this.formulario.get('situacao') as FormControl;
  }
}
