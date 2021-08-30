import { AlunoService } from './../aluno.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { Aluno } from '../model/aluno.model';


@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  styleUrls: ['./aluno-list.component.css']
})
export class AlunoListComponent implements OnInit {

  alunos: Aluno[] = [];
  colunas: String[] = ['id', 'nome', 'situacao', 'acoes']

  totalElementos = 0;
  pagina = 0;
  tamanho = 10;
  pageSizeOptions: number[] = [5, 10];

  constructor(
    private alunoService: AlunoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.listarAlunos(this.pagina, this.tamanho)

  }


  listarAlunos(pagina = 0, tamanho = 5) {
    this.alunoService.list(pagina, tamanho).subscribe(
      response => {
        this.alunos = response.content;
        this.totalElementos = response.totalElements;
        this.pagina = response.number;
      })
  }

  paginar(event: PageEvent) {
    this.pagina = event.pageIndex;
    this.listarAlunos(this.pagina, this.tamanho);
  }


  navigateToNovoAluno(): void {
    this.router.navigate(['/aluno/alunoForm'])
  }

}
