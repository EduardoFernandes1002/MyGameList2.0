import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getGeneros(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/generos`);
  }

  getPlataformas(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/plataformas`);
  }

  getModosDeJogo(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/modos`);
  }
}
