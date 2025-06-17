import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../../service/jogo-service/jogo.service';
import { RouterModule } from '@angular/router';
import { GameCardComponent } from '../../../component/game-card/game-card.component';

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [FormsModule, CommonModule, GameCardComponent, RouterModule],
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.css'],
})
export class RankComponent implements OnInit {
  jogos: any[] = []; // Lista de jogos para o ranking
  // Filtros de tempo disponíveis
  private readonly timeFilters = [
    { days: Infinity }, // Todos os tempos.
    { days: 30 }, // Ultimos 30 dias.
    { days: 7 }, // Ultimos 7 dias.
  ];

  constructor(private jogoService: JogoService) {}

  ngOnInit(): void {
    this.carregarRank();
  }

  carregarRank(): void {
    this.jogoService.getRankingJogos().subscribe({
      next: (data: any) => {
        this.jogos = (data && data.content) ? data.content : (data || []);
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      }
    });
  }

  public toSlug = (nomeJogo: string): string => {
    return nomeJogo
      ? nomeJogo
          .toLowerCase()
          .normalize('NFD')
          .replace(/\p{Diacritic}/gu, '')
          .replace(/[^a-z0-9]+/g, '-')
          .replace(/(^-|-$)+/g, '')
      : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };
}
