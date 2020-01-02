import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Person } from 'src/app/model/person';
import { ConfigService } from './config.service';

@Injectable({
  providedIn: 'root',
})
export class PersonService {

  constructor(
    private httpClient: HttpClient,
    private configService: ConfigService) {
  }

  public getPersons(): Observable<Person[]> {
    return this.httpClient.get<Person[]>(this.configService.getFullUrl('/persons'));
  }
}
