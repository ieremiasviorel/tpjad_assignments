import { Injectable } from '@angular/core';

import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ConfigService {

  constructor() {
  }

  public getFullUrl(relativePath: string): string {
    return environment.baseUrl + relativePath;
  }
}
