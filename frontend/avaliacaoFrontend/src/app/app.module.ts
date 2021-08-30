import { AlunoCalcularAnoComponent } from './aluno/aluno-calcular-ano/aluno-calcular-ano.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FooterComponent } from './template/footer/footer.component';
import { SidenavComponent } from './template/sidenav/sidenav.component';
import { LayoutComponent } from './layout/layout.component';
import { HomeComponent } from './home/home.component';

import { ReactiveFormsModule } from '@angular/forms';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input'
import { MatSelectModule } from '@angular/material/select';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule } from '@angular/forms';


import { HttpClientModule } from '@angular/common/http';
import { NgxMaskModule } from 'ngx-mask';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { AlunoDeleteComponent } from './aluno/aluno-delete/aluno-delete.component';
import { AlunoEditarComponent } from './aluno/aluno-editar/aluno-editar.component';
import { AlunoFormComponent } from './aluno/aluno-form/aluno-form.component';
import { AlunoListComponent } from './aluno/aluno-list/aluno-list.component';
import { LancamentoNotaListComponent } from './lancamentoNota/lancamento-nota-list/lancamento-nota-list.component';
import { LancamentoNotaFormComponent } from './lancamentoNota/lancamento-nota-form/lancamento-nota-form.component';
import { LancamentoNotaDeleteComponent } from './lancamentoNota/lancamento-nota-delete/lancamento-nota-delete.component';
import { AnoBimestreListComponent } from './anoBimestre/ano-bimestre-list/ano-bimestre-list.component';
import { AnoBimestreFormComponent } from './anoBimestre/ano-bimestre-form/ano-bimestre-form.component';
import { MatDatepickerModule } from '@angular/material/datepicker';


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    SidenavComponent,
    LayoutComponent,
    HomeComponent,
    AlunoDeleteComponent,
    AlunoEditarComponent,
    AlunoFormComponent,
    AlunoListComponent,
    LancamentoNotaListComponent,
    LancamentoNotaFormComponent,
    LancamentoNotaDeleteComponent,
    AnoBimestreListComponent,
    AnoBimestreFormComponent,
    AlunoCalcularAnoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatExpansionModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule,
    MatSnackBarModule,
    MatPaginatorModule,
    MatTableModule,
    MatTabsModule,
    FormsModule,
    MatDatepickerModule,
    NgxMaskModule.forRoot({
      dropSpecialCharacters: false
    })
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
