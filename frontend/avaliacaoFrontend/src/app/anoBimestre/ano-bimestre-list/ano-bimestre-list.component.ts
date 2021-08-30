import { AnoBimestre } from './../model/anoBimestre.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { AnoBimestreService } from '../ano-bimestre.service';

@Component({
  selector: 'app-ano-bimestre-list',
  templateUrl: './ano-bimestre-list.component.html',
  styleUrls: ['./ano-bimestre-list.component.css']
})
export class AnoBimestreListComponent implements OnInit {

  bimestres: AnoBimestre[] = [];
  colunas: String[] = ['ano', 'bimestre', 'acoes']

  totalElementos = 0;
  pagina = 0;
  tamanho = 10;
  pageSizeOptions: number[] = [5, 10];

  constructor(
    private anoBimestreService: AnoBimestreService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.listarBimestres(this.pagina, this.tamanho)

  }

  listarBimestres(pagina = 0, tamanho = 5) {
    this.anoBimestreService.list(pagina, tamanho).subscribe(
      response => {
        this.bimestres = response.content;
        this.totalElementos = response.totalElements;
        this.pagina = response.number;
      })
  }

  paginar(event: PageEvent) {
    this.pagina = event.pageIndex;
    this.listarBimestres(this.pagina, this.tamanho);
  }

  navigateToGerarBimestres(): void {
    this.router.navigate(['/anoBimestre/anoBimestreForm'])
  }

  deletarBimestre(id: string): void {
    this.anoBimestreService.delete(+id).subscribe(() => {
      this.anoBimestreService.showMessage("Bimestre excluído com sucesso!");
     this.load();
    });
  }

  load() {
    location.reload()
  }

}
