import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TagService {

  private apiUrl = 'localhost:8080/api/generos';

  constructor(private http: HttpClient) { }

  getGeneros(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  searchGeneros(term: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/search?term=${term}`);
  }

  getJogosByGenero(nomeGenero: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/${nomeGenero}/jogos`);
  }
}
