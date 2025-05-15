import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CommentsService } from '../../service/comments/comments.service';

@Component({
  selector: 'app-comments',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent implements OnChanges {
  @Input() nomeJogo: string = '';
  comments: any[] = [];
  currentPage: number = 0;
  pageSize: number = 20;
  loading: boolean = false;

  constructor(private commentsService: CommentsService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['nomeJogo'] && this.nomeJogo) {
      this.currentPage = 0;
      this.comments = [];
      this.loadComments();
    }
  }

  loadComments(): void {
    this.loading = true;
    this.commentsService.getCommentsByGame(this.nomeJogo, this.currentPage, this.pageSize).subscribe({
      next: (data: any) => {
        this.comments = data.content;
        this.loading = false;
      },
      error: (error: any) => {
        this.loading = false;
        console.error('Erro ao carregar comentários:', error);
      }
    });
  }

  loadMore(): void {
    this.currentPage++;
    this.loading = true;
    this.commentsService.getCommentsByGame(this.nomeJogo, this.currentPage, this.pageSize).subscribe({
      next: (data: any) => {
        this.comments = [...this.comments, ...data.content];
        this.loading = false;
      },
      error: (error: any) => {
        this.loading = false;
        console.error('Erro ao carregar mais comentários:', error);
      }
    });
  }
}
