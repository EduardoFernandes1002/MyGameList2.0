import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

// Interface que define a estrutura de um jogo
interface Game {
  id: string;
  name: string;
  score: number;
  image: string;
  genre: string;
  platform: string;
  position: number;
  date: Date;
}

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.css'],
})
export class RankComponent implements OnInit {
  allGames: Game[] = []; // Lista de todos os jogos (dados brutos)
  filteredGames: Game[] = []; // Lista de jogos filtrados com base nos critérios de tempo e pesquisa
  currentPage = 1; // Página atual para paginação
  itemsPerPage = 20; // Número de itens exibidos por página
  searchQuery = ''; // String de busca para filtrar jogos pelo nome
  selectedTab = 0; // Aba selecionada para aplicar filtros de tempo

  // Filtros de tempo disponíveis
  private readonly timeFilters = [
    { days: Infinity }, // Todos os tempos
    { days: 30 }, // Ultimos 30 dias
    { days: 7 }, // Ultimos 7 dias
  ];

  /**
   * Método do ciclo de vida do Angular chamado ao inicializar o componente.
   * - Gera dados fictícios (temporário).
   * - Aplica os filtros iniciais.
   */
  ngOnInit(): void {
    this.generateMockData(); // Temporário: será substituído por uma chamada ao backend.
    this.applyFilters();
  }

  /**
   * Gera 2000 jogos fictícios com propriedades aleatórias.
   * - Temporário: será substituído por uma chamada ao backend para buscar dados reais.
   */
  private generateMockData(): void {
    const platforms = ['PC', 'PS5', 'XBOX'];
    const genres = ['Ação', 'Aventura', 'RPG'];

    this.allGames = Array.from({ length: 2000 }, (_, i) => {
      const randomDays = Math.floor(Math.random() * 365);
      return {
        id: `game-${i}`,
        name: `Jogo ${i + 1}`,
        score: Math.floor(Math.random() * 1000),
        image: 'https://via.placeholder.com/80',
        genre: genres[Math.floor(Math.random() * genres.length)],
        platform: platforms[Math.floor(Math.random() * platforms.length)],
        position: i + 1,
        date: new Date(Date.now() - randomDays * 24 * 60 * 60 * 1000),
      };
    });
  }

  /**
   * Aplica filtros de tempo e ordenação à lista de jogos.
   * - Filtra jogos com base no tempo selecionado.
   * - Ordena os jogos por pontuação em ordem decrescente.
   * - Atualiza a posição dos jogos na lista.
   */
  applyFilters(): void {
    const filter = this.timeFilters[this.selectedTab];
    const cutoffDate = new Date();
    cutoffDate.setDate(cutoffDate.getDate() - filter.days);

    this.filteredGames = this.allGames
      .filter((game) => filter.days === Infinity || game.date >= cutoffDate)
      .sort((a, b) => b.score - a.score)
      .map((game, index) => ({ ...game, position: index + 1 }));

    this.applySearch();
  }

  /**
   * Filtra os jogos com base no nome digitado na barra de pesquisa.
   * - Reseta a página atual para 1 após aplicar o filtro.
   */
  applySearch(): void {
    this.filteredGames = this.filteredGames.filter((game) =>
      game.name.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
    this.currentPage = 1;
  }

  /**
   * Retorna os jogos da página atual com base na paginação.
   * - Calcula o índice inicial e final da página.
   */
  get currentRanking(): Game[] {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.filteredGames.slice(start, end);
  }

  /**
   * Calcula o número total de páginas com base no número de jogos filtrados.
   */
  get totalPages(): number {
    return Math.ceil(this.filteredGames.length / this.itemsPerPage);
  }

  /**
   * Atualiza a página atual para o número especificado, se for válido.
   * - Ignora se o número da página for inválido ou fora do intervalo.
   */
  goToPage(page: number | string): void {
    if (typeof page !== 'number') return;

    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }

  /**
   * Gera um array de números e reticências para exibir a paginação.
   * - Exemplo: [1, '...', 4, 5, 6, '...', 10].
   */
  get pages(): (number | string)[] {
    const total = this.totalPages;
    const current = this.currentPage;
    const delta = 2;
    const range: (number | string)[] = [];

    if (total <= 7) {
      return Array.from({ length: total }, (_, i) => i + 1);
    }

    range.push(1);
    let start = Math.max(2, current - delta);
    let end = Math.min(total - 1, current + delta);

    if (current - 1 <= delta) {
      end = 1 + delta * 2;
    }
    if (total - current <= delta) {
      start = total - delta * 2;
    }
    if (start > 2) range.push('...');

    for (let i = start; i <= end; i++) {
      if (i > 1 && i < total) range.push(i);
    }

    if (end < total - 1) range.push('...');
    range.push(total);

    return range;
  }

  /**
   * Atualiza a aba selecionada e reaplica os filtros.
   * - Cada aba corresponde a um filtro de tempo (ex.: "Todos os tempos", "Última semana").
   */
  onTabChange(tab: number): void {
    this.selectedTab = tab;
    this.applyFilters();
  }
}
