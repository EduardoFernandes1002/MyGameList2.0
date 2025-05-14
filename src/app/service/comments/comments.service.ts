import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {

  constructor() { }
  
  checkComment(comment: string): boolean {
    return comment.length > 0;
  }

}
