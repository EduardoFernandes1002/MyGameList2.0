import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JogoService } from '../../../service/jogo/jogo.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ CommonModule,FormsModule ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  jogos: any[] = [];
  recommendedGames: any[] = [];
  highestRatedGames: any[] = [];

  constructor(private jogoService: JogoService) {}

  ngOnInit(): void {
    this.loadTopFive();
    this.loadRecommendedGames();
    this.loadHighestRatedGames();
  }

  loadTopFive(): void {
    this.jogoService.getJogoResumidoByTopCinco().subscribe({
      next: (data: any) => {
        this.jogos = data.content || data;
        
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      }
    });
  }

  loadRecommendedGames(): void {
    this.jogoService.getJogoRecomendados().subscribe({
      next: (data: any) => {
        this.recommendedGames = data.content || data;
      },
      error: (error: any) => {
        console.error('Erro ao carregar recomendados:', error);
      }
    });
  }

  loadHighestRatedGames(): void {
    this.jogoService.getJogoMaisBemAvaliados().subscribe({
      next: (data: any) => {
        this.highestRatedGames = data.content || data;
      },
      error: (error: any) => {
        console.error('Erro ao carregar mais bem avaliados:', error);
      }
    });
  }

  public chunkArray(array: any[], chunkSize: number): any[] {
    const chunks = [];
    for (let i = 0; i < array.length; i += chunkSize) {
      chunks.push(array.slice(i, i + chunkSize));
    }
    return chunks;
  }
}

