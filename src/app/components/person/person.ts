import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PersonService, Person } from '../../services/person.service';

@Component({
  selector: 'app-person',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './person.html'
})
export class PersonComponent {
  persons: Person[] = [];
  newPerson: Person = { id_person: 0, fio: '', gender: 'м' };

  constructor(private personService: PersonService) {
    this.loadPersons();
  }

  loadPersons() {
    
    this.personService.getAll().subscribe((data) => {this.persons = data; console.log(data)} );
  }

  addPerson() {
    this.personService.create(this.newPerson).subscribe(() => {
      this.loadPersons();
      this.newPerson = { id_person: 0, fio: '', gender: 'м' };
    });
  }

  deletePerson(id: number) {
    this.personService.delete(id).subscribe(() => this.loadPersons());
  }
}