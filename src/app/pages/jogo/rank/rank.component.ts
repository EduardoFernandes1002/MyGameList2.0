import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { GameCardComponent } from '../../../component/game-card/game-card.component';
import { JogoService } from '../../../service/jogo-service/jogo.service';

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterModule, GameCardComponent],
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.css'],
})
export class RankComponent implements OnInit {
  jogos: any[] = []; // Lista de jogos para o ranking
  paginaAtual: number = 0;
  temMaisPaginas: boolean = true;
  tamanhoPagina: number = 12; // igual ao backend
  quantidadeUltimaPagina: number = 0;
  totalPaginas: number = 0;
  paginas: number[] = [];

  // Filtros de tempo disponíveis
  private readonly timeFilters = [
    { days: Infinity }, // Todos os tempos.
    { days: 30 }, // Ultimos 30 dias.
    { days: 7 }, // Ultimos 7 dias.
  ];

  constructor(private jogoService: JogoService) {}

  ngOnInit(): void {
    this.carregarRank(0);
  }

  carregarRank(pagina: number): void {
    this.jogoService.getRankingJogos(pagina).subscribe({
      next: (data: any) => {
        if (
          (data.content?.length === 0 || data.length === 0) &&
          pagina > this.paginaAtual
        ) {
          this.temMaisPaginas = false;
          return;
        }

        this.jogos = data.content || data;
        this.paginaAtual = pagina;
        this.temMaisPaginas = true;

        this.totalPaginas = data.totalPages || 1;
        this.paginas = Array.from({ length: this.totalPaginas }, (_, i) => i);
      },

      error: (err) => console.error('Erro ao carregar ranking:', err),
    });
  }

  public toSlug = (nomeJogo: string): string => {
    return nomeJogo ? nomeJogo.toLowerCase().replace(/\s+/g, '-') : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };
}
