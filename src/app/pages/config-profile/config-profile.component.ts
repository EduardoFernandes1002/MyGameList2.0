import { Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-config-profile',
  imports: [FormsModule, BrowserModule],
  templateUrl: './config-profile.component.html',
  styleUrl: './config-profile.component.css'
})
export class ConfigProfileComponent {
  perfil = {
    apelido: '',
    email: '',
    senha: ''
  };
}
