import { AlunoCalcularAnoComponent } from './aluno/aluno-calcular-ano/aluno-calcular-ano.component';
import { LancamentoNotaDeleteComponent } from './lancamentoNota/lancamento-nota-delete/lancamento-nota-delete.component';
import { LancamentoNotaFormComponent } from './lancamentoNota/lancamento-nota-form/lancamento-nota-form.component';
import { AnoBimestreListComponent } from './anoBimestre/ano-bimestre-list/ano-bimestre-list.component';
import { AlunoEditarComponent } from './aluno/aluno-editar/aluno-editar.component';
import { AlunoDeleteComponent } from './aluno/aluno-delete/aluno-delete.component';
import { AlunoListComponent } from './aluno/aluno-list/aluno-list.component';
import { HomeComponent } from './home/home.component';
import { LayoutComponent } from './layout/layout.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlunoFormComponent } from './aluno/aluno-form/aluno-form.component';
import { AnoBimestreFormComponent } from './anoBimestre/ano-bimestre-form/ano-bimestre-form.component';
import { LancamentoNotaListComponent } from './lancamentoNota/lancamento-nota-list/lancamento-nota-list.component';

const routes: Routes = [

  {
    path: '',
    component: LayoutComponent, children: [
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
      }

    ]
  },

  {
    path: 'aluno',
    component: LayoutComponent, children: [
      {
        path: 'alunoForm',
        component: AlunoFormComponent
      },

      {
        path: 'alunoLista',
        component: AlunoListComponent
      },

      {
        path: 'deletar/:id',
        component: AlunoDeleteComponent
      },


      {
        path: 'editar/:id',
        component: AlunoEditarComponent
      },

      {
        path: 'calcularAno/:id',
        component: AlunoCalcularAnoComponent
      },


      {
        path: '',
        redirectTo: '/aluno/alunoLista',
        pathMatch: 'full'
      }
    ]
  },

  {
    path: 'anoBimestre',
    component: LayoutComponent, children: [
      {
        path: 'anoBimestreForm',
        component: AnoBimestreFormComponent
      },

      {
        path: 'anoBimestreLista',
        component: AnoBimestreListComponent
      },

      {
        path: 'deletar/:id',
        component: AlunoDeleteComponent
      },

      {
        path: '',
        redirectTo: '/anoBimestre/anoBimestreLista',
        pathMatch: 'full'
      }
    ]
  },

  {
    path: 'lancamentoNota',
    component: LayoutComponent, children: [
      {
        path: 'lancamentoNotaForm',
        component: LancamentoNotaFormComponent
      },

      {
        path: 'lancamentoNotaLista',
        component: LancamentoNotaListComponent
      },

      {
        path: 'deletar/:id',
        component: LancamentoNotaDeleteComponent
      },

      {
        path: '',
        redirectTo: '/lancamento/LancamentoNotaLista',
        pathMatch: 'full'
      }
    ]
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
