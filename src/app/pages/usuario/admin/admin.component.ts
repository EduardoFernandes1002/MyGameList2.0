import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../../service/jogo-service/jogo.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  imports: [CommonModule, FormsModule],
  standalone: true,
})
export class AdminComponent implements OnInit {
  // Variáveis para o autocomplete de gêneros
  nomeJogo: string = '';
  sinopseJogo: string = '';
  imagemJogo: string = '';
  dataLancamentoJogo: string = '';
  distribuidora: string = '';
  desenvolvedora: string = '';
  generos: string[] = [];
  modos: string[] = [];
  plataformas: string[] = [];

  // Formulário do jogo
  jogos: any[] = [];
  usuarios: any[] = [];

  constructor(private jogoService: JogoService) {}
  ngOnInit(): void {
    this.loadAllJogos();
  }

  loadAllJogos(): void {
    this.jogoService.getJogos().subscribe({
      next: (data: any) => {
        this.jogos = data.content || data;
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      },
    });
  }

  adicionarJogo(): void {
    this.generos = this.generos
    .map((g) => g.split(',')
    .map((s) => s.trim())).flat();

    this.modos = this.modos
      .map((m) => m.split(',')
      .map((s) => s.trim())).flat();

    this.plataformas = this.plataformas
      .map((p) => p.split(',')
      .map((s) => s.trim())).flat();


    const jogo = {
      nomeJogo: this.nomeJogo,
      sinopseJogo: this.sinopseJogo,
      imagemJogo: this.imagemJogo,
      dataLancamentoJogo: this.dataLancamentoJogo,
      distribuidora: this.distribuidora,
      desenvolvedora: this.desenvolvedora,
    };

    const generos = this.generos;
    const modos = this.modos;
    const plataformas = this.plataformas;

    this.jogoService.adicionarJogo(jogo, generos, plataformas, modos).subscribe(() => {
      console.log('Jogo adicionado com sucesso!');
    });
  }
}