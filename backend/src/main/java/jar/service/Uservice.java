package jar.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jar.model.Student;
import jar.repo.StudentRepo;

@Service
public class Uservice {

    StudentRepo db;

    public Uservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> us(Integer id, Student d) {

        Map<Object, Object> res = new HashMap<>();

        Optional<Student> data = db.findById(id);

        if (data.isPresent()) {

            Student s = data.get();

            s.setName(d.getName());
            s.setEmail(d.getEmail());
            s.setIp(d.getIp());

            db.save(s);

            res.put("msg", "Student Updated Successfully");
            res.put("status", 200);
            res.put("data", s);

        } else {

            res.put("msg", "Student Not Found");
            res.put("status", 404);
        }

        return res;
    }
}