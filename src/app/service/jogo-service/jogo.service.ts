import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JogoService {

  
  private apiUrl = 'http://localhost:8080/api/jogo';

  constructor(private http: HttpClient) {}

  // Busca de todos os jogos (Utilizavel na admin e talvez reutilizavel em outro lugar)
  getJogos(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  // Informações do jogo (comentarios service em src\app\service\comments)
  getJogoByNome(nome: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${nome}`);
  }


  // serviço para busca de jogos no a Home
  getJogoResumidoByTopCinco(): Observable<any[]>{
    return this.http.get<any[]>(`${this.apiUrl}/rank/cinco`)
  }

  // Jogos recomendados para o usuário (endpoint a ser implementado no backend)
  getJogoRecomendados(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/recomendados`);
  }

  // Jogos mais bem avaliados (endpoint a ser implementado no backend)
  getJogoMaisBemAvaliados(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/mais-bem-avaliados`);
  }

  // Busca jogos do ranking
  getRankingJogos(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/rank`);
  }
}