import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {
  private apiUrl = 'http://localhost:8080/api/avaliacao';

  constructor(private http: HttpClient) {}

  getCommentsByGame(slug: string, page: number, size: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/jogo/comment/${slug}?page=${page}`);
  }

  checkComment(comment: string): boolean {
    return comment.length > 0;
  }
}
