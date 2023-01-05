package com.nds.karyawan.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nds.karyawan.model.Karyawan;
import com.nds.karyawan.repository.KaryawanRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class KaryawanController {
    @Autowired
    KaryawanRepository karyawanRepository;

    @GetMapping("/karyawan")
    public ResponseEntity<List<Karyawan>> getAllKaryawan(@RequestParam(required = false) String nama_karyawan, String no_hp, String start, String end) {
        System.out.println(start+" "+end);
        try {
            List<Karyawan> karyawans = new ArrayList<Karyawan>();

            if (nama_karyawan == null && no_hp != null && start == null && end == null){
                karyawanRepository.findByPhone(no_hp).forEach(karyawans::add);
                }
            else if (nama_karyawan != null && no_hp == null && start == null && end == null){
                karyawanRepository.findByNameContaining(nama_karyawan).forEach(karyawans::add);
            } else if (start != null && end != null && nama_karyawan == null && no_hp == null) {
                karyawanRepository.findByJoinDate(start,end).forEach(karyawans::add);
            } else{
                karyawanRepository.findAll().forEach(karyawans::add);
            }



            if (karyawans.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(karyawans, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/karyawan/{id}")
    public ResponseEntity<Karyawan> getKaryawanById(@PathVariable("id") int id) {
        Karyawan karyawan = karyawanRepository.findById(id);

        if (karyawan != null) {
            System.out.println(karyawan.getTanggal_masuk_kerja());
            return new ResponseEntity<>(karyawan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/karyawan")
    public ResponseEntity<String> createKaryawan(Karyawan karyawan) {
        try {
            karyawanRepository.save(new Karyawan(karyawan.getNama_karyawan(),
                    karyawan.getTanggal_masuk_kerja(), karyawan.getNo_hp(),
                    karyawan.getLimit_reimbursement()));
            return new ResponseEntity<>("Karyawan was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}




