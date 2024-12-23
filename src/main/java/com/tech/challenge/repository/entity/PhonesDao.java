package com.tech.challenge.repository.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "phones")
public class PhonesDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_info_id", nullable = false)
    private UserInfoDao userInfo;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String cityCode;

    @Column(nullable = false)
    private String countryCode;

    public static PhonesDao AssociateUserToPhones(UserInfoDao userInfo, String number, String cityCode, String countryCode){
        PhonesDao phonesDao = new PhonesDao();
        phonesDao.setUserInfo(userInfo);
//        phonesDao.setId(UUID.randomUUID());
        phonesDao.setNumber(number);
        phonesDao.setCityCode(cityCode);
        phonesDao.setCountryCode(countryCode);

        return phonesDao;
    }
}
