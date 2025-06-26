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
  newPerson: Person = { id_person: 0, fio: '', gender: '' };

  constructor(private personService: PersonService) {
    this.loadPersons();
  }
  editMode: boolean = false;
  editPerson: Person | null = null;
  loadPersons() {
    
    this.personService.getAll().subscribe((data) => {this.persons = data; console.log(data)} );
  }

  addPerson() {
    this.personService.create(this.newPerson).subscribe(() => {
      this.loadPersons();
      this.newPerson = { id_person: 0, fio: '', gender: '' };
    });
  }

  deletePerson(id: number) {
    this.personService.delete(id).subscribe(() => this.loadPersons());
  }
  startEdit(person: Person) {
    this.editPerson = { ...person };
    this.editMode = true;
  }

  saveEdit() {
    if (!this.editPerson) return;
    this.personService.update(this.editPerson.id_person, this.editPerson).subscribe(() => {
      this.loadPersons();
      this.editPerson = null;
      this.editMode = false;
    });
  }
  searchId: number = 0;
  foundPerson: Person | null = null;
  searchPerson() {
    this.personService.getById(this.searchId).subscribe({
      next: (data) => this.foundPerson = data,
      error: () => this.foundPerson = null
    });
  }
}