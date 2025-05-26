import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GeralService {

  private apiUrl = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) { }

  getJogos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/jogo/resumido`);
  }

  getTop5Jogos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/jogo/top5`);
  }
}
