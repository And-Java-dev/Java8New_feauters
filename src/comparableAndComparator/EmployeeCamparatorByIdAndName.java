package comparableAndComparator;

import java.util.Comparator;

public class EmployeeCamparatorByIdAndName implements Comparator<Employee> {
    @Override
    public int compare(Employee o, Employee o2) {
        int flag = o.getId() - o2.getId();
        if (flag == 0){
            flag = o.getName().compareTo(o2.getName());
        }
        return flag;
    }
}
