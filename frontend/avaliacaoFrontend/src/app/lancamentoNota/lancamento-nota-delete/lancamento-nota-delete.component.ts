import { Router, ActivatedRoute } from '@angular/router';
import { LancamentoNotaService } from './../lancamentoNota.service';
import { LancamentoNota } from './../model/lancamentoNota.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lancamento-nota-delete',
  templateUrl: './lancamento-nota-delete.component.html',
  styleUrls: ['./lancamento-nota-delete.component.css']
})
export class LancamentoNotaDeleteComponent implements OnInit {
  lancamentoNota: LancamentoNota;

  constructor(
    private lancamentoNotaService: LancamentoNotaService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.activeRoute.snapshot.paramMap.get('id')!;
    this.lancamentoNotaService.readById(id).subscribe((lancamentoNota) => {
      this.lancamentoNota = lancamentoNota;
    })
  }

  deleteAluno(): void {
    this.lancamentoNotaService.delete(this.lancamentoNota.id).subscribe(() => {
      this.lancamentoNotaService.showMessage("Notas excluídas com sucesso!");
      this.router.navigate(["/lancamentoNota/lancamentoNotaLista"]);
    });
  }

  cancelar() {
    this.router.navigate(["/lancamentoNota/lancamentoNotaLista"]);
  }
}
