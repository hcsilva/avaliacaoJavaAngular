import { AnoBimestre } from './model/anoBimestre.model';
import { environment } from '../../environments/environment';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable, EMPTY } from 'rxjs';
import { catchError, map } from "rxjs/operators";
import { PaginaAnoBimestre } from './model/paginaAnoBimestre';


@Injectable({
  providedIn: 'root'
})
export class AnoBimestreService {

  baseUrl: string = '/api/anoBimestre';
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

  findAllByAno(ano: string): Observable<AnoBimestre[]> {
    const url = `${this.apiUrl + this.baseUrl + "/findAno"}/${ano}`;
    return this.http.get<AnoBimestre[]>(url).pipe(
      map((obj) => obj)
    );
  }

  gerarBimestres(ano: String): Observable<AnoBimestre> {
    const url = `${this.apiUrl + this.baseUrl + "/gerarBimestres"}/${ano}`;
    return this.http.post<AnoBimestre>(url, ano)
      .pipe(map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu um erro!", true);
    return EMPTY;
  }

  list(page: any, size: any): Observable<PaginaAnoBimestre> {
    const params = new HttpParams()
      .set('page', page)
      .set('size', size)

    return this.http.get<any>(`${this.apiUrl + this.baseUrl}?${params.toString()}`);
  }

  delete(id: number): Observable<AnoBimestre> {
    console.log(id);
    const url = `${this.apiUrl + this.baseUrl}/${id}`;
    return this.http.delete<AnoBimestre>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

}
