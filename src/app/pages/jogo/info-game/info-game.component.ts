import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JogoService } from '../../../service/jogo-service/jogo.service';
import { ComentarioComponent } from '../../../component/comentario/comentario.component';
import { FormsModule } from '@angular/forms';
import { ComentarioService } from '../../../service/comentario-service/comentario.service';

@Component({
  selector: 'app-info-game',
  imports: [CommonModule, ComentarioComponent, FormsModule],
  templateUrl: './info-game.component.html',
  styleUrl: './info-game.component.css',
  standalone: true,
})
export class InfoGameComponent implements OnInit {
  jogo: any = {};
  avaliando = false;
  comentarioUsuario: string = '';
  notaSelecionada: number | null = null;
  jaAvaliou = false; // Defina true se o usuário já avaliou este jogo

  constructor(
    private jogoService: JogoService,
    private comentarioService: ComentarioService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const nomeJogo = params.get('nomeJogo');
      if (nomeJogo) {
        this.jogoService.getJogoByNome(nomeJogo).subscribe({
          next: (data: any) => {
            this.jogo = data;
          },
          error: (error: any) => {
            console.error('Erro ao buscar o jogo:', error);
          },
        });
      }
    });
  }

  selecionarNota(nota: number) {
    this.notaSelecionada = nota;
    this.avaliando = false;
    // Aqui você pode já enviar a nota para o backend, se quiser
  }

  enviarComentario() {
    // Envie notaSelecionada e comentarioUsuario para o backend
    // Depois, limpe os campos e atualize a lista de comentários
    this.comentarioUsuario = '';
    this.notaSelecionada = null;
    this.jaAvaliou = true;
  }

  loadJogo(): void {
    this.route.paramMap.subscribe((params) => {
      const nomeJogo = params.get('nomeJogo');
      if (nomeJogo) {
        this.jogoService.getJogoByNome(nomeJogo).subscribe({
          next: (data: any) => {
            this.jogo = data;
          },
          error: (error: any) => {
            console.error('Erro ao buscar o jogo:', error);
          },
        });
      }
    });
  }

  mostrarAvaliacao() {
    this.avaliando = true;
  }
  avaliarNota(nota: number) {
    // Aqui você pode enviar a nota para o backend ou fazer outra ação
    this.avaliando = false; // esconde os botões após avaliar, se quiser
  }
}
