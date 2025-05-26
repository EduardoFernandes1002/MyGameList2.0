import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TagService {

  private apiUrl = 'https://sua-api.com/tags'; // Substitua pela sua URL

  constructor(private http: HttpClient) { }

  getAllTags(): Observable<string[]> {
    return this.http.get<string[]>(this.apiUrl);
  }

  searchTags(term: string): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/search?term=${term}`);
  }
}
