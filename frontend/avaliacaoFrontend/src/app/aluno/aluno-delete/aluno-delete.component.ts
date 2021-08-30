import { AlunoService } from './../aluno.service';
import { Component, OnInit } from '@angular/core';
import { Aluno } from '../model/aluno.model';
import { ActivatedRoute, Router } from '@angular/router';




@Component({
  selector: 'app-aluno-delete',
  templateUrl: './aluno-delete.component.html',
  styleUrls: ['./aluno-delete.component.css']
})
export class AlunoDeleteComponent implements OnInit {

  aluno: Aluno;

  constructor(
    private alunoService: AlunoService,
    private router: Router,
    private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const id = +this.activeRoute.snapshot.paramMap.get('id')!;
    this.alunoService.readById(id).subscribe((aluno) => {
      this.aluno = aluno;
    })
  }

  deleteAluno(): void {
    this.alunoService.delete(this.aluno.id).subscribe(() => {
      this.alunoService.showMessage("Aluno excluído com sucesso!");
      this.router.navigate(["/aluno/alunoLista"]);
    });
  }

  cancelar() {
    this.router.navigate(["/aluno/alunoLista"]);
  }

}
