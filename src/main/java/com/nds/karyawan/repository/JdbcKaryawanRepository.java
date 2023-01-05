package com.nds.karyawan.repository;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nds.karyawan.model.Karyawan;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcKaryawanRepository implements KaryawanRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Karyawan karyawan) {
        return jdbcTemplate.update("INSERT INTO karyawan (nama_karyawan, tanggal_masuk_kerja, no_hp, limit_reimbursement) VALUES (?,?,?,?)",
                new Object[] {karyawan.getNama_karyawan(), karyawan.getTanggal_masuk_kerja(),
                               karyawan.getNo_hp(), karyawan.getLimit_reimbursement()});
    }

    @Override
    public int update(Karyawan karyawan) {
        return jdbcTemplate.update("UPDATE karyawan SET nama_karyawan=?, tanggal_masuk_kerja=?," +
                                    " no_hp=?, limit_reimbursement=? WHERE id=?",
                new Object[] { karyawan.getNama_karyawan(), karyawan.getTanggal_masuk_kerja(),
                               karyawan.getNo_hp(), karyawan.getLimit_reimbursement(),
                               karyawan.getId() });
    }

    @Override
    public Karyawan findById(int id) {
        try {
            Karyawan karyawan = jdbcTemplate.queryForObject("SELECT * FROM karyawan WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Karyawan.class), id);

            return karyawan;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM karyawan WHERE id=?", id);
    }

    @Override
    public List<Karyawan> findAll() {
        return jdbcTemplate.query("SELECT * from karyawan", BeanPropertyRowMapper.newInstance(Karyawan.class));
    }

    @Override
    public List<Karyawan> findByPhone(String phone) {
        return jdbcTemplate.query("SELECT * from karyawan WHERE no_hp LIKE '%"+phone+"%'",
                BeanPropertyRowMapper.newInstance(Karyawan.class));
    }

    @Override
    public List<Karyawan> findByNameContaining(String name) {
        String q = "SELECT * from karyawan WHERE nama_karyawan ILIKE '%" + name + "%'";

        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Karyawan.class));
    }
    @Override
    public int deleteAll() {
            return jdbcTemplate.update("DELETE from karyawan");
        }

    @Override
    public List<Karyawan> findByJoinDate(String start, String end){
        String q = "SELECT * from karyawan WHERE tanggal_masuk_kerja BETWEEN '"+start+"' AND '"+end+"'";
        return jdbcTemplate.query( q, BeanPropertyRowMapper.newInstance(Karyawan.class));
    }
}
