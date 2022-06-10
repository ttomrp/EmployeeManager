import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from './employee'
import { EmployeeService } from './employee.services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ClientCode';

  // TODO: note the '!' was added to avoid an error.  currently unsure why.
  public employees!: Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe({
      next: (response: Employee[]) => {
        this.employees = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }

  public onOpenModal(employee: Employee, mode: string): void {

    const container = document.getElementById('main-container');

    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    switch (mode) {
      case 'add':
        button.setAttribute('data-target', '#addEmployeeModal');
        break;
      case 'edit':
        button.setAttribute('data-target', '#updateEmployeeModal');
        break;
      case 'delete':
        button.setAttribute('data-target', '#deleteEmployeeModal');
        break;
    }

    container?.appendChild(button);
    button.click();
  }

}
