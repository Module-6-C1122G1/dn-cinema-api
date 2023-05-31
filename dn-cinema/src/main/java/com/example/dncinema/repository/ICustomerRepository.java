package com.example.dncinema.repository;

import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from customer where id_customer= :id", nativeQuery = true)
    Customer getByIdCus(@Param("id") Integer id);

    @Query(value = "select * from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerTicket(@Param("pageable") Pageable pageable);

    @Query(value = "select * from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerPointHistory(@Param("pageable") Pageable pageable);

    @Query(value = "select date_booking from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<Customer> findAllPlusPoint(@Param("pageable") Pageable pageable,@Param("startDate") LocalDate startDate,@Param("dateEnd") LocalDate dateEnd);

    @Query(value = "select date_booking from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<Customer> findAllUsePoint(@Param("pageable") Pageable pageable,@Param("startDate")  LocalDate startDate,@Param("dateEnd")  LocalDate dateEnd);

    @Query(value = "update product set id_type_customer=2 where id=:customer.idCustomer", nativeQuery = true)
    void updateGold(@Param("customer") Customer customer);

    @Query(value = "update product set id_type_customer=3 where id=:customer.idCustomer", nativeQuery = true)
    void updateDiamond(@Param("customer") Customer customer);

    Customer findByAccountUser_NameAccount(String nameAcc);
    /**
     * @param nameCustomer
     * @param point_customer
     * @param gender
     * @param phone
     * @param address
     * @param email
     * @param identity_card
     * @param img_customer
     * @param id_type_customer
     * @param id_account
     */
    @Modifying
    @Transactional
    @Query(value = "insert into customer(name_customer , date_of_birth, point_customer , gender , phone , address , email , identity_card ,img_customer, id, id_type_customer)" +
            " values (:name_customer,:date_of_birth, :point_customer,:gender,:phone , :address , :email , :identity_card, :img_customer , :id_account, :id_type_customer)", nativeQuery = true)
    void saveCustomer(@Param("name_customer") String nameCustomer,
                      @Param("date_of_birth") LocalDate date_of_birth,
                      @Param("point_customer") Double point_customer,
                      @Param("gender") String gender,
                      @Param("phone") String phone,
                      @Param("address") String address,
                      @Param("email") String email,
                      @Param("identity_card") String identity_card,
                      @Param("img_customer") String img_customer,
                      @Param("id_type_customer") Integer id_type_customer,
                      @Param("id_account") Integer id_account);


    /**
     * @param nameCustomer
     * @param point_customer
     * @param gender
     * @param phone
     * @param address
     * @param email
     * @param identity_card
     * @param img_customer
     * @param id_type_customer
     * @param id_account
     */
    @Modifying
    @Transactional
    @Query(value = "update customer set name_customer = :name_customer,date_of_birth=:date_of_birth, point_customer = :point_customer ," +
            " gender = :gender ,phone = :phone,address = :address ,email = :email,identity_card = :identity_card, img_customer=:img_customer," +
            "id_type_customer=:id_type_customer,id=:id_account WHERE id_customer = :id_customer", nativeQuery = true)
    void updateCustomerAccount(@Param("name_customer") String nameCustomer,
                               @Param("date_of_birth") LocalDate date_of_birth,
                               @Param("point_customer") Double point_customer,
                               @Param("gender") String gender,
                               @Param("phone") String phone,
                               @Param("address") String address,
                               @Param("email") String email,
                               @Param("identity_card") String identity_card,
                               @Param("img_customer") String img_customer,
                               @Param("id_type_customer") Integer id_type_customer,
                               @Param("id_account") int id_account,
                               @Param("id_customer") int id_customer);

    /**
     * @param customerId
     * @return
     */
    @Transactional
    @Query(value = "select * from customer where id_customer = :id_customer", nativeQuery = true)
    Customer findByIdCustomer(@Param("id_customer") Integer  customerId);

    /**
     * @author ChinhLV
     * @param email
     * @return đối tượng có tên Customer được tìm thấy dựa theo email
     */
    Customer findCustomersByEmail(String email);
    Customer findCustomersByPhone(String phone);
    Customer findCustomersByIdentityCard(String identity);

};


