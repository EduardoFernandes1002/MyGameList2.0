import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JogoService } from '../../../service/jogo-service/jogo.service';
import { ComentarioComponent } from '../../../component/comentario/comentario.component';

@Component({
  selector: 'app-info-game',
  imports: [CommonModule, ComentarioComponent],
  templateUrl: './info-game.component.html',
  styleUrl: './info-game.component.css'
})
export class InfoGameComponent implements OnInit {
  jogo: any = {};

  constructor(private jogoService: JogoService, private route: ActivatedRoute) {}

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
          complete: () => {
            console.log('Requisição concluída.');
          }
        });
      }
    });
  }
}
