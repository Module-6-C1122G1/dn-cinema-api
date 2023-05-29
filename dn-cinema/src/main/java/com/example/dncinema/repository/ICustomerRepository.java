package com.example.dncinema.repository;

import com.example.dncinema.model.AccountUser;
import com.example.dncinema.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.time.LocalDate;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerTicket(Pageable pageable);

    @Query(value = "select * from customer\n" +
            "join ticket on ticket.id_customer = customer.id_customer\n" +
            "join seat on ticket.id_seat = seat.id_seat\n" +
            "join show_time on show_time.id_seat = seat.id_seat\n" +
            "join film on film.id_show_time = show_time.id_show_time", nativeQuery = true)
    Page<Customer> findAllCustomerPointHistory(Pageable pageable);

    @Query(value = "select date_booking from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<Customer> findAllPlusPoint(Pageable pageable, LocalDate startDate, LocalDate dateEnd);

    @Query(value = "select date_booking from ticket where date_booking between '2023-01-01' and '2023-12-30'", nativeQuery = true)
    Page<Customer> findAllUsePoint(Pageable pageable, LocalDate startDate, LocalDate dateEnd);

    /**
     * @param nameCustomer
     * @param point_customer
     * @param gender
     * @param phone
     * @param address
     * @param email
     * @param identity_card
     * @param img_customer
     * @param id_type
     * @param id_account
     */
    @Modifying
    @Transactional
    @Query(value = "insert into customer(name_customer , point_customer , gender , phone , address , email , identity_card ,img_customer, id_type_customer, id)" +
            " values (:name_customer,:point_customer,:gender,:phone , :address , :email , :identity_card, :img_customer , :id_type, :id_account)", nativeQuery = true)
    void saveCustomer(@Param("name_customer") String nameCustomer,
                      @Param("point_customer") Double point_customer,
                      @Param("gender") String gender,
                      @Param("phone") String phone,
                      @Param("address") String address,
                      @Param("email") String email,
                      @Param("identity_card") String identity_card,
                      @Param("img_customer") String img_customer,
                      @Param("id_type") Integer id_type,
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
     * @param id_type
     * @param id_account
     */
    @Modifying
    @Transactional
    @Query(value = "update customer set name_customer = :name_customer, point_customer = :point_customer ," +
            " gender = :gender ,phone = :phone,address = :address ,email = :email,identity_card = :identity_card, img_customer=:img_customer," +
            "id_type_customer=:id_type,id=:id_account WHERE id_customer = :id_customer", nativeQuery = true)
    void updateCustomerAccount(@Param("name_customer") String nameCustomer,
                               @Param("point_customer") Double point_customer,
                               @Param("gender") String gender,
                               @Param("phone") String phone,
                               @Param("address") String address,
                               @Param("email") String email,
                               @Param("identity_card") String identity_card,
                               @Param("img_customer") String img_customer,
                               @Param("id_type") int id_type,
                               @Param("id_account") int id_account,
                               @Param("id_customer") int id_customer);

    /**
     * @param customerId
     * @return
     */
    @Transactional
    @Query(value = "select * from customer where id_customer = :id_customer", nativeQuery = true)
    Customer findByIdCustomer(@Param("id_customer") Integer customerId);

    @Query(value = "select * from customer where email like :email", nativeQuery = true)
    Customer findByEmail(String email);
};


