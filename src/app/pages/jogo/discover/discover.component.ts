import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DescobertaService } from '../../../service/descoberta-service/descoberta.service';
import { GameCardComponent } from '../../../component/game-card/game-card.component';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-discover',
  standalone: true,
  imports: [CommonModule, GameCardComponent, FormsModule],
  templateUrl: './discover.component.html',
  styleUrl: './discover.component.css',
})
export class DiscoverComponent implements OnInit {
  jogos: any[] = [];
  jogosFiltrados: any[] = [];
  filtroBusca: string = '';
  tipo: string = '';
  nomeCategoria: string = '';
  carregando = false;
  erro: string | null = null;

  constructor(
    private descobertaService: DescobertaService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.tipo = params.get('tipo') || '';
      console.log(this.tipo);
      this.nomeCategoria = params.get('nomeCategoria') || '';
      this.buscarJogos();
    });
  }

  buscarJogos() {
    this.carregando = true;
    this.erro = null;

    // Padroniza o parâmetro para slug (caso o backend aceite)
    const slugCategoria = this.toSlug(this.nomeCategoria);

    const tipoParaMetodo: { [key: string]: (slug: string) => any } = {
      generos: (slug) => this.descobertaService.getJogosPorGenero(slug),
      plataformas: (slug) => this.descobertaService.getJogosPorPlataforma(slug),
      modos: (slug) => this.descobertaService.getJogosPorModoDeJogo(slug),
    };

    const metodo = tipoParaMetodo[this.tipo];
    if (metodo) {
      metodo(slugCategoria).subscribe({
        next: (data: any[]) => {
          this.jogos = data;
          this.jogosFiltrados = data; // inicializa com todos
          this.carregando = false;
        },
        error: (err: any) => {
          this.erro = 'Erro ao buscar jogos.';
          this.carregando = false;
          console.error(err);
        }
      });
    } else {
      this.jogos = [];
      this.jogosFiltrados = [];
      this.carregando = false;
      this.erro = 'Categoria não encontrada.';
    }
  }

  filtrarJogos() {
    const busca = this.filtroBusca.trim().toLowerCase();
    if (!busca) {
      this.jogosFiltrados = [...this.jogos];
    } else {
      this.jogosFiltrados = this.jogos.filter(j =>
        j.nomeJogo.toLowerCase().includes(busca)
      );
    }
  }

    public toSlug = (nome: string): string => {
    return nome ? nome.toLowerCase().replace(/\s+/g, '-') : '';
  };

  public trackBySlug = (index: number, jogo: any): string => {
    return this.toSlug(jogo?.nomeJogo);
  };

  
}