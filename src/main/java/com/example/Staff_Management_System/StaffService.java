package com.example.Staff_Management_System;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private Map<Long,StaffClass> Staffs = new ConcurrentHashMap<>();

    private AtomicLong Atoid = new AtomicLong();

    public Collection<StaffClass> getallstaff(){
        return Staffs.values();
    }
    public StaffClass Getstaffbyid(Long id){
        return Staffs.get(id);
    }
    public StaffClass register(StaffClass newStaff){
        Long Staffid = newStaff.getId() != null? newStaff.getId() : Atoid.incrementAndGet();
        newStaff.setId(Staffid);
        Staffs.put(Staffid,newStaff);
        return newStaff;
    }
    public StaffClass Updatestaff(Long id , StaffClass newStaff) {
        if (Staffs.containsKey(id)) {
            StaffClass previousdata = Getstaffbyid(id);

            previousdata.setName(newStaff.getName());
            previousdata.setAddress(newStaff.getAddress());
            Staffs.put(id, previousdata);
            return previousdata;
        }
        else
            return null;
    }
    public StaffClass DeleteStaff(Long id){
        return Staffs.remove(id);
    }
}
