import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JogoService } from '../../../service/jogo-service/jogo.service';
import { RouterModule } from '@angular/router';
import { GameCardComponent } from '../../../component/game-card/game-card.component';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule, GameCardComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  jogos: any[] = [];
  highestRatedGames: any[] = [];

  constructor(private jogoService: JogoService) {}

  ngOnInit(): void {
    this.loadTopFive();
    this.loadHighestRatedGames();
  }

  loadTopFive(): void {
    this.jogoService.getJogoResumidoByTopCinco().subscribe({
      next: (data: any) => {
        this.jogos = (data && data.content) ? data.content : (data || []);
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      },
    });
  }

  loadHighestRatedGames(): void {
    this.jogoService.getJogoMaisBemAvaliados().subscribe({
      next: (data: any) => {
        this.highestRatedGames = (data && data.content) ? data.content : (data || []);
      },
      error: (error: any) => {
        console.error('Erro ao carregar mais bem avaliados:', error);
      },
    });
  }

  public chunkArray(array: any[], chunkSize: number): any[] {
    const chunks = [];
    for (let i = 0; i < array.length; i += chunkSize) {
      chunks.push(array.slice(i, i + chunkSize));
    }
    return chunks;
  }

  public toSlug = (nomeJogo: string): string => {
    return nomeJogo ? nomeJogo.toLowerCase().replace(/\s+/g, '-') : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };
}
