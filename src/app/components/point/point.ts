import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Point, PointService } from '../../services/point.service';

@Component({
  selector: 'app-point',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './point.html'
})
export class PointComponent {
  points: Point[] = [];
  newPoint: Point = {
    id_point: 0,
    city: '',
    address: '',
    phone: '',
    fioHeader: ''
  };

  constructor(private pointService: PointService) {
    this.loadPoints();
  }

  loadPoints() {
    this.pointService.getAll().subscribe(data => this.points = data);
  }

  addPoint() {
    this.pointService.create(this.newPoint).subscribe(() => {
      this.loadPoints();
      this.newPoint = { id_point: 0, city: '', address: '', phone: '', fioHeader: '' };
    });
  }

  deletePoint(id: number) {
    this.pointService.delete(id).subscribe(() => this.loadPoints());
  }
  editMode: boolean = false;
  editPoint: Point | null = null;
  newPoint1: any = { id_point: 0, city: '', address: '', phone: '', fioHeader: '' };
  startEdit(point: Point) {
  this.editMode = true;
  this.editPoint = { ...point };
}

saveEdit() {
  if (!this.editPoint) return;
  this.pointService.update(this.editPoint.id_point, this.editPoint).subscribe(() => {
    this.loadPoints();
    this.editPoint = null;
    this.editMode = false;

  });
}
}