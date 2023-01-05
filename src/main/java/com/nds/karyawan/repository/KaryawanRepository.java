package com.nds.karyawan.repository;
import java.util.Date;
import java.util.List;
import com.nds.karyawan.model.Karyawan;

public interface KaryawanRepository {

        int save(Karyawan karyawan);

        int update(Karyawan karyawan);

        Karyawan findById(int id);

        int deleteById(int id);

        List<Karyawan> findAll();

        List<Karyawan> findByPhone(String phone);

        List<Karyawan> findByJoinDate(String start, String end);

        List<Karyawan> findByNameContaining(String name);

        int deleteAll();
}
