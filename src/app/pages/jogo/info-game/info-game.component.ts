import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JogoService } from '../../../service/jogo-service/jogo.service';
import { ComentarioComponent } from '../../../component/comentario/comentario.component';
import { FormsModule } from '@angular/forms';
import { ComentarioService } from '../../../service/comentario-service/comentario.service';
import { AuthService } from '../../../service/auth/auth.service';

@Component({
  selector: 'app-info-game',
  imports: [CommonModule, ComentarioComponent, FormsModule],
  templateUrl: './info-game.component.html',
  styleUrl: './info-game.component.css',
  standalone: true,
})
export class InfoGameComponent implements OnInit {
  jogo: any = {};
  comentarioUsuario: string = '';
  exibindoNotas = false;
  jaAvaliou = false;
  usuario: any = {};
  listasDisponiveis = [
    { idLista: 2, nome: 'Jogando' },
    { idLista: 3, nome: 'Completo' },
    { idLista: 4, nome: 'Abandonado' },
    { idLista: 5, nome: 'Pausado' },
    { idLista: 6, nome: 'Desejo' },
  ];
  listaSelecionada: number | null = null;

  constructor(
    private jogoService: JogoService,
    private comentarioService: ComentarioService,
    private authService: AuthService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.loadUsuarioLogado();
    this.loadJogo();
  }

  private loadUsuarioLogado() {
    this.authService.getInfosUsuarioLogado().subscribe({
      next: (usuario: any) => {
        this.usuario = Array.isArray(usuario) ? usuario[0] : usuario;
        this.loadAvaliacaoUsuario();
      },
      error: () => {
        this.usuario = {};
        this.comentarioUsuario = '';
        this.jaAvaliou = false;
      },
    });
  }

  private loadAvaliacaoUsuario() {
    if (!this.usuario?.idUsuario || !this.jogo?.idJogo) return;
    this.comentarioService
      .getAvaliacaoUsuarioJogo(this.usuario.idUsuario, this.jogo.idJogo)
      .subscribe({
        next: (avaliacao: any) => {
          if (avaliacao && typeof avaliacao.notaUsuario === 'number') {
            this.usuario.notaUsuario = avaliacao.notaUsuario;
            this.comentarioUsuario = avaliacao.comentarioUsuario || '';
            this.jaAvaliou = true;
          } else {
            this.usuario.notaUsuario = null;
            this.comentarioUsuario = '';
            this.jaAvaliou = false;
          }
        },
        error: () => {
          this.usuario.notaUsuario = null;
          this.comentarioUsuario = '';
          this.jaAvaliou = false;
        },
      });
  }

  enviarComentario() {
    if (!this.usuario.notaUsuario) {
      alert('Dê uma nota antes de comentar!');
      return;
    }
    const comentario =
      this.comentarioUsuario && this.comentarioUsuario.trim().length > 0
        ? this.comentarioUsuario
        : null;
    if (!comentario) {
      alert('Digite um comentário!');
      return;
    }
    this.comentarioService
      .salvarComentario(
        this.jogo.idJogo,
        this.usuario.idUsuario,
        this.comentarioUsuario,
        this.usuario.notaUsuario
      )
      .subscribe({
        next: () => {
          alert('Comentário enviado com sucesso!');
        },
        error: (err) => {
          alert('Erro ao enviar comentário: ' + (err.error || ''));
        },
      });
  }

  loadJogo(): void {
    this.route.paramMap.subscribe((params) => {
      const nomeJogo = params.get('nomeJogo');
      if (nomeJogo) {
        this.jogoService.getJogoByNome(nomeJogo).subscribe({
          next: (data: any) => {
            this.jogo = data;
            this.loadAvaliacaoUsuario();
          },
          error: () => {},
        });
      }
    });
  }
  mostrarNotas() {
    this.exibindoNotas = true;
  }

  selecionarNota(nota: number) {
    this.usuario.notaUsuario = nota;
    this.exibindoNotas = false;
    if (!this.usuario?.idUsuario) {
      alert('Usuário não logado!');
      return;
    }
    this.comentarioService
      .salvarNota(this.jogo.idJogo, this.usuario.idUsuario, nota)
      .subscribe({
        next: () => {
          this.jaAvaliou = true;
        },
        error: (err) => {
          alert('Erro ao salvar nota: ' + (err.error || ''));
        },
      });
  }

  podeAvaliar(): boolean {
    return this.isUsuarioLogado() && !this.usuario.notaUsuario;
  }

  isUsuarioLogado(): boolean {
    return this.authService.isAuthenticated();
  }

  adicionarJogo(idLista: number) {
    this.authService
      .adicionarJogoNaLista(this.usuario.idUsuario, idLista, this.jogo.idJogo)
      .subscribe({
        next: () => alert('Jogo adicionado à lista!'),
        error: (err) => alert('Erro ao adicionar: ' + (err.error || '')),
      });
  }

  adicionarFavorito() {
    this.authService
      .adicionarJogoNaLista(this.usuario.idUsuario, 7, this.jogo.idJogo)
      .subscribe({
        next: () => alert('Jogo adicionado à lista!'),
        error: (err) => alert('Erro ao adicionar: ' + (err.error || '')),
      });
  }
}
