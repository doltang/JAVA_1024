package studentAttendenceExample;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendence {
	private ArrayList<Student> stds = new ArrayList<Student>();
	private ArrayList<Log> log = new ArrayList<Log>();
}
