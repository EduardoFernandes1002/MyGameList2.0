import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private apiUrl = 'http://localhost:8080/api'

  constructor( private http: HttpClient, ) { }

  getGeneros(): Observable<[]> {
    return this.http.get<[]>(`${this.apiUrl}/generos`)
  }

  getPlataformas(): Observable<[]> {
    return this.http.get<[]>(`${this.apiUrl}/plataformas`)
  }

  getModosDeJogo(): Observable<[]> {
    return this.http.get<[]>(`${this.apiUrl}/modo`)
  }

  getJogosPorGenero(genero: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/generos/${genero}/jogos`)
  }

  getJogosPorPlataforma(plataforma: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/plataformas/${plataforma}/jogos`)
  }

  getJogosPorModoDeJogo(modoDeJogo: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/modo/${modoDeJogo}/jogos`)
  }
}
