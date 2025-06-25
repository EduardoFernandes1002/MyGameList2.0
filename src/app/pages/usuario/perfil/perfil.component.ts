import { Component, OnInit } from '@angular/core';
import { GameCardComponent } from '../../../component/game-card/game-card.component';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../../service/auth/auth.service';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-perfil',
  imports: [CommonModule, GameCardComponent, RouterModule, FormsModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
  standalone: true
})
export class PerfilComponent implements OnInit {
  jogos: any[] = [];
  usuario: any[] = [];
  lista: number = 1;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loadListaUsuario();
    this.loadInfosUsuarioLogado();
  }

  loadInfosUsuarioLogado() {
    this.authService.getInfosUsuarioLogado().subscribe({
      next: (data: any) => {
        this.usuario = data.content || data;
        
      },
      error: (error: any) => {
        console.error('Erro ao carregar informações do usuario:', error);
      }
    });
  }

  loadListaUsuario() {
    this.authService.getJogosListaUsuario(this.lista).subscribe({
      next: (data: any) => {  
        this.jogos = data.content || data;
        
      },
      error: (error: any) => {
        console.error('Erro ao carregar lista atual:', error);
      }
    });
  }



  public toSlug = (nomeJogo: string): string => {
    return nomeJogo ? nomeJogo.toLowerCase().replace(/\s+/g, '-') : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };
}
