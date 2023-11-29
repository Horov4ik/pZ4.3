import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository {
    public List<Employee> employeeRepository = new ArrayList<>(
            List.of(
                    new Employee(1, "Марія", "Дмитренко", Gender.FEMALE, 60, 50000, 10, Speciality.BACKAND_DEVELOPER),
                    new Employee(2, "Катя", "Чернікова", Gender.FEMALE, 19, 7000, 4, Speciality.FRONTEND_DEVELOPER),
                    new Employee(3, "Влад", "Хоров'як", Gender.MALE, 20, 1000, 1, Speciality.BACKAND_DEVELOPER),
                    new Employee(4, "Бодя", "Макрон", Gender.MALE, 50, 5000, 3, Speciality.FRONTEND_DEVELOPER),
                    new Employee(5, "Андрій", "Садлов", Gender.MALE, 60, 8500, 6, Speciality.BACKAND_DEVELOPER))

    );

    public String[] getNameAndSurnameOfTopBySalary() {
        return employeeRepository.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .map(employee -> employee.getName() + " " + employee.getLastName())
                .toArray(String[]::new);
    }

    public Map<Speciality, List<Employee>> groupBySpeciality() {
        return employeeRepository.stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality, Collectors.toList()));
    }

    public int getTotalSalaryForQAFemalesWithLowExperience() {
        return employeeRepository.stream()
                .filter(e -> e.getSpeciality() == Speciality.QA && e.getWorkExperience() <= 5 && e.getGender() == Gender.FEMALE)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty() {
        return employeeRepository.stream()
                .anyMatch(e -> e.getWorkExperience() > 20 &&
                        e.getSpeciality() == Speciality.BACKAND_DEVELOPER && e.getSpeciality() == Speciality.DEV_OPS && e.getGender() == Gender.MALE);
    }

    public String getDescendingSalaryWithFullName() {
        return employeeRepository.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(employee -> String.format("%s %s %d%n", employee.getName(), employee.getLastName(), employee.getSalary()))
                .collect(Collectors.joining(";"));
    }

    public Map<Speciality, Double> getAverageSalaryBySpeciality() {
        return employeeRepository.stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality, Collectors.averagingDouble(Employee::getSalary)));
    }

}
