import { CanActivateFn } from '@angular/router';
import { AuthService } from '../../service/auth/auth.service';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

export const adminGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);

  const token = authService.getToken();
  const permissao = authService.getUserRoleFromToken();

  if (!token || permissao !== 'Administrador') {
    router.navigate(['/']);
    return false;
  }

  return true;
};
