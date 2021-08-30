import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { catchError, map } from "rxjs/operators";
import { Aluno } from './model/aluno.model';
import { PaginaAluno } from './model/paginaAluno';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  baseUrl: string = '/api/aluno';
  apiUrl: string = environment.apiUrl;


  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient) { }


  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, "X", {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ["msg-error"] : ["msg-sucess"],
    });
  }

  findAll(): Observable<Aluno[]> {
    const url = `${this.apiUrl + this.baseUrl + "/findAll"}`;
    return this.http.get<Aluno[]>(url).pipe(
      map((obj) => obj)
    );
  }

  salvar(aluno: Aluno): Observable<Aluno> {
    return this.http.post<Aluno>(this.apiUrl + this.baseUrl, aluno)
      .pipe(map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  readById(id: number): Observable<Aluno> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.get<Aluno>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  update(id: number, aluno: Aluno): Observable<Aluno> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.put<Aluno>(url, aluno).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  delete(id: number): Observable<Aluno> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.delete<Aluno>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu um erro!", true);
    return EMPTY;
  }

  list(page: any, size: any): Observable<PaginaAluno> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)

    return this.http.get<any>(`${this.apiUrl + this.baseUrl}?${params.toString()}`);
  }

  realizarCalculoSituacaoAluno(ano: string, id: number, aluno: Aluno): Observable<Aluno> {
    const url = `${this.apiUrl + this.baseUrl}/calcularNota/ano/${ano}/aluno/${id}`;
    return this.http.post<Aluno>(url, aluno)
      .pipe(map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

}
