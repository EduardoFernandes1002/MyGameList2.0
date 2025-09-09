import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ComentarioService } from  '../../service/comentario-service/comentario.service';
import { AuthService } from '../../service/auth/auth.service';

@Component({
  selector: 'app-comentario',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './comentario.component.html',
  styleUrl: './comentario.component.css'
})
export class ComentarioComponent implements OnChanges {
  @Input() nomeJogo: string = '';
  comments: any[] = [];
  currentPage: number = 0;
  pageSize: number = 20;
  loading: boolean = false;
  hasMore: boolean = true;

  constructor(private comentarioService: ComentarioService, private authService: AuthService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['nomeJogo'] && this.nomeJogo) {
      this.currentPage = 0;
      this.comments = [];
      this.loadComments();
    }
  }

  private toSlug(nome: string): string {
    return nome ? nome.trim().toLowerCase().replace(/\s+/g, '-') : '';
  }

  loadComments(): void {
    this.loading = true;
    const slug = this.toSlug(this.nomeJogo);
    this.comentarioService.getCommentsByGame(slug, this.currentPage, this.pageSize).subscribe({
      next: (data: any) => {
        // Novo formato: backend retorna lista direta, não mais paginada
        this.comments = data.content || data;
        this.hasMore = false; // Não há mais paginação
        this.loading = false;
      },
      error: (error: any) => {
        this.loading = false;
        this.hasMore = false;
        console.error('Erro ao carregar comentários:', error);
      }
    });
  }

  loadMore(): void {
    // Apenas desabilita o botão
    this.hasMore = false;
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
}
