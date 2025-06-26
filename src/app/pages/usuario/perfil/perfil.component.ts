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
  usuario: any = {};
  lista: number = 1;
  jogosFavoritos: any[] = [];
  listaNome: any;
  isPerfilProprio: boolean = false;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loadListaUsuario();
    this.loadInfosUsuarioLogado();
    this.loadNomeLista();
  }

  loadInfosUsuarioLogado() {
    this.authService.getInfosUsuarioLogado().subscribe({
      next: (data: any) => {
        this.usuario = data.content || data;

        // Obtenha o usuário logado (ajuste conforme seu AuthService)
      // Pega o nome do usuário logado pelo token
      const nomeUsuarioLogado = this.authService.getNomeUsuarioFromToken();

      // Verifica se é o próprio perfil
      this.isPerfilProprio = nomeUsuarioLogado && this.usuario.nomeUsuario && (nomeUsuarioLogado === this.usuario.nomeUsuario);
        
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

    this.authService.getJogosListaUsuario(7).subscribe({
      next: (data: any) => {  
        this.jogos = data.content || data;
        
      },
      error: (error: any) => {
        console.error('Erro ao carregar lista atual:', error);
      }
    });
  }

  loadNomeLista() {
  this.authService.getNomeLista(this.lista).subscribe({
    next: (data: any) => {
      this.listaNome = data.content || data;
    },
    error: (error: any) => {
      console.error('Erro ao carregar nome da lista:', error);}
  });
}



  public toSlug = (nomeJogo: string): string => {
    return nomeJogo ? nomeJogo.toLowerCase().replace(/\s+/g, '-') : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };
}
