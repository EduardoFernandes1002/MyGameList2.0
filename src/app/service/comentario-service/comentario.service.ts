import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ComentarioService {
  private apiUrl = 'http://localhost:8080/api/avaliacao';

  constructor(private http: HttpClient) {}

  // Coleta jogos com base na pagina em que está aberta mesmo digindo com '-'
  getCommentsByGame(slug: string, page: number, size: number): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/jogo/comment/${slug}?page=${page}&size=${size}`
    );
  }

  getComentariosRecentes(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/api/avaliacao/recentes');
  }

  // Verifica se comentarios existem (validação apenas)
  checkComment(comment: string): boolean {
    return comment.length > 0;
  }
}
