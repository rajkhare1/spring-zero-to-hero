package com.rajkhare.khareschool.repository;

import com.rajkhare.khareschool.constant.EazySchoolConstants;
import com.rajkhare.khareschool.models.Contact;
import com.rajkhare.khareschool.rowmappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/*
@Repository stereotype annotations is used to add a bean of this class
type to Spring context and indicate that given bean is used to perform
DB related operations.
* */
@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Contact> contactRowMapper = (resultSet, rowNum) -> {
        Contact contact = new Contact();
        contact.setContactId(resultSet.getInt("CONTACT_ID"));
        contact.setName(resultSet.getString("NAME"));
        contact.setMobileNum(resultSet.getString("MOBILE_NUM"));
        contact.setEmail(resultSet.getString("EMAIL"));
        contact.setSubject(resultSet.getString("SUBJECT"));
        contact.setMessage(resultSet.getString("MESSAGE"));
        contact.setStatus(resultSet.getString("STATUS"));
        contact.setCreatedAt(resultSet.getTimestamp("CREATED_AT").toLocalDateTime());
        contact.setCreatedBy(resultSet.getString("CREATED_BY"));

        if(null!=resultSet.getTimestamp("UPDATED_AT")){
            contact.setUpdatedAt(resultSet.getTimestamp("UPDATED_AT").toLocalDateTime());
        }
        contact.setUpdatedBy(resultSet.getString("UPDATED_BY"));
        return contact;
    };

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveContactMsg(Contact contact) {
        String sql = "insert into contact_msg (name,mobile_num,email,subject,message,status," +
                "created_at,created_by) values (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),
                contact.getEmail(),contact.getSubject(),contact.getMessage(),contact.getStatus(),
                contact.getCreatedAt(),contact.getCreatedBy());
    }

    public List<Contact> findMsgsWithStatus(String status) {
        String sql = "select * from contact_msg where status = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status);
            }
        },contactRowMapper);
    }

    public int updateMsgStatus(int contactId, String status, String updatedBy) {
        String sql = "update contact_msg set status = ?, updated_by = ?, updated_at = ? where contact_id = ?";
        return jdbcTemplate.update(sql, ps -> {
            ps.setString(1, status);
            ps.setString(2, updatedBy);
            ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(4, contactId);
        });
    }

}
