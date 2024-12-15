import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { InfoGameComponent } from './pages/info-game/info-game.component';
import { RankComponent } from './pages/rank/rank.component';
import { AdminComponent } from './pages/admin/admin.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'info', component: InfoGameComponent },
  { path: 'rank', component: RankComponent },
  { path: 'perfil', component: PerfilComponent },
  { path: 'admin', component: AdminComponent }
];
