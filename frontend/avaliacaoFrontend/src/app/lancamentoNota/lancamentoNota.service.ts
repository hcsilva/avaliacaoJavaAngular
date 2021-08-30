import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { catchError, map } from "rxjs/operators";
import { LancamentoNota } from './model/lancamentoNota.model';
import { LancamentoNotaPagina } from './model/lancamentoNotaPagina';

@Injectable({
  providedIn: 'root'
})
export class LancamentoNotaService {

  baseUrl: string = '/api/lancamentoNota';
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

  salvar(lancamentoNota: LancamentoNota): Observable<LancamentoNota> {

    return this.http.post<LancamentoNota>(this.apiUrl + this.baseUrl, lancamentoNota)
      .pipe(map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  readById(id: number): Observable<LancamentoNota> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.get<LancamentoNota>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  update(id: number, lancamentoNota: LancamentoNota): Observable<LancamentoNota> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    console.log('Salvar: '+lancamentoNota.id);

    return this.http.put<LancamentoNota>(url, lancamentoNota).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  delete(id: number): Observable<LancamentoNota> {
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.delete<LancamentoNota>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu um erro!", true);
    return EMPTY;
  }

  list(page: any, size: any): Observable<LancamentoNotaPagina> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)

    return this.http.get<any>(`${this.apiUrl + this.baseUrl}?${params.toString()}`);
  }

}
