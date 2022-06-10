import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"
import { Observable } from "rxjs";
import { Employee } from "./employee";
import { environment } from "src/environments/environment";

/*
HttpClient is a built in Http client in Angular that we can use to make requests.  
We import this and pass into the constructor.
*/

@Injectable({ providedIn: "root" })
export class EmployeeService {

    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) { }

    /*
    GET Request
    */
    public getEmployees(): Observable<Employee[]> {
        return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
    }

    /*
    POST Request
    */
    public addEmployee(employee: Employee): Observable<Employee> {
        return this.http.post<Employee>(`${this.apiServerUrl}/employee/add`, employee);
    }

    /*
    PUT Request
    */
    public updateEmployee(employee: Employee): Observable<Employee> {
        return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
    }

    /*
    DELETE Request
    */
    public deleteEmployee(employeeId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
    }
}