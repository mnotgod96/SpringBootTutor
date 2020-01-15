package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    List<Integer> nums = new ArrayList<>();

    public CourseRepository() {
        for(int i = 0; i < 10; i++) {
            nums.add(i);
        }
    }

    public List<Integer> findIndices(String inputString) {
        List<Integer> idx = new ArrayList<>();
        idx.add(-1);
        idx.add(-1);
        int target = Integer.parseInt(inputString);
        int i, j = 0;
        boolean found = false;
        for(i = 0; i < nums.size(); i++) {
            int diff = target - nums.get(i);
            for(j = i+1; j < nums.size(); j++) {
                if(diff == nums.get(j)) {
                    found = true;
                    break;
                }
            }
            if(found) {
                idx.set(0, i);
                idx.set(1, j);
                return idx;
            }
        }
        return idx;
    }
}
