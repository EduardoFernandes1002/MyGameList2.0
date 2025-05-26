import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'; 

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
  standalone: false
})
export class PerfilComponent implements OnInit {
  nomeUsuario: any;
  idade: number | null = null;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {
    const nomeUsuario = this.route.snapshot.paramMap.get('nomeUsuario');
    if (nomeUsuario) {
      this.http.get<any>(`http://localhost:8080/api/usuarios/username/${nomeUsuario}`).subscribe(usuario => {
        this.nomeUsuario = usuario.nomeUsuario;
      });
    }
  }
}
