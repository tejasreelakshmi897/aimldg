package jar.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import jar.repo.StudentRepo;

@Service
public class Rservice {

    StudentRepo db;

    public Rservice(StudentRepo db) {
        this.db = db;
    }

    public Map<Object, Object> rs() {

        Map<Object, Object> res = new HashMap<>();

        res.put("msg", "Student Fetched Successfully");
        res.put("status", 200);
        res.put("data", db.findAll());

        return res;
    }
}