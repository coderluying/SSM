package map;

import pojo.Student;
import pojo.Teacher;

import java.util.List;

public interface TeacherMap {

   public List<Teacher> findTeacherStudents(int id) throws Exception;

   public Teacher findTeacherByName(String name)throws Exception;
}
