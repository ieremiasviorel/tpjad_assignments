import { Component, OnInit } from '@angular/core';

import { PersonService } from 'src/app/service/person.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './person-list.component.html',
  styleUrls: [ './person-list.component.css' ],
})
export class PersonListComponent implements OnInit {
  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
    this.personService.getPersons().subscribe(console.log, console.warn);
  }
}
