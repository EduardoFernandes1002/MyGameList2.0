import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {  } from '@angular/platform-browser';

@Component({
  selector: 'app-config',
  imports: [ FormsModule ],
  templateUrl: './config.component.html',
  styleUrl: './config.component.css'
})
export class ConfigComponent {
  user = {
    username: '',
    nickname: '',
    email: '',
    password: '',
    phone: '',
    birthdate: '',
  };

  onSubmit() {
    console.log('Alterações salvas:', this.user);
  }

  onDelete() {
    console.log('Conta excluída');
  }
}