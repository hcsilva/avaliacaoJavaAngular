import { LancamentoNotaService } from './../lancamentoNota.service';
import { LancamentoNota } from './../model/lancamentoNota.model';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';


@Component({
  selector: 'app-lancamento-nota-list',
  templateUrl: './lancamento-nota-list.component.html',
  styleUrls: ['./lancamento-nota-list.component.css']
})
export class LancamentoNotaListComponent implements OnInit {
  lancamentoNotas: LancamentoNota[] = [];
  colunas: String[] = ['aluno', 'faltas', 'anoBimestre', 'partSala', 'entregaTarefas', 'trabalhoBim', 'provaBim', 'acoes'];

  totalElementos = 0;
  pagina = 0;
  tamanho = 5;
  pageSizeOptions: number[] = [5, 10];

  constructor(
    private lancamentoService: LancamentoNotaService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.listarLancamentoNotas(this.pagina, this.tamanho)
  }

  listarLancamentoNotas(pagina = 0, tamanho = 5) {
    this.lancamentoService.list(pagina, tamanho).subscribe(
      response => {
        this.lancamentoNotas = response.content;
        this.totalElementos = response.totalElements;
        this.pagina = response.number;
      })
  }

  paginar(event: PageEvent) {
    this.pagina = event.pageIndex;
    this.listarLancamentoNotas(this.pagina, this.tamanho);
  }


  navigateToNovoLancamentoNotas(): void {
    this.router.navigate(['/lancamentoNota/lancamentoNotaForm'])
  }
}
