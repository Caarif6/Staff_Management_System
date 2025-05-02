package com.example.Staff_Management_System;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staff/")
public class StaffController {
    private final StaffService staffservice;

    public StaffController(StaffService staffservice) {
        this.staffservice = staffservice;
    }
    @GetMapping("all")
    public Collection<StaffClass> getstaffs(){
        return staffservice.getallstaff();
    }
    @GetMapping("{id}")
    public StaffClass stafff(@PathVariable Long id){
        return staffservice.Getstaffbyid(id);
    }

    @PostMapping("all")
    public StaffClass Insertion(@RequestBody StaffClass newStaff){
        return staffservice.register(newStaff);
    }
    @PutMapping("{id}")
    public StaffClass Updates(@PathVariable Long id, @RequestBody StaffClass newStaff){
        return staffservice.Updatestaff(id,newStaff);
    }
    @DeleteMapping("{id}")
    public StaffClass Deleting(@PathVariable Long id){
        return staffservice.DeleteStaff(id);
    }
}
