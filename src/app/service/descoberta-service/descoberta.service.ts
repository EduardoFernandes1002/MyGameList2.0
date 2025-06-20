import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DescobertaService {

  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getJogosPorGenero(slugGenero: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/generos/${slugGenero}/jogos`);
  }

  getJogosPorPlataforma(slugPlataforma: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/plataformas/${slugPlataforma}/jogos`);
  }

  getJogosPorModoDeJogo(slugModo: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/modo/${slugModo}/jogos`);
  }
}
