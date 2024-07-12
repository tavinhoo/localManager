package com.example.gasManager.infrastructure.adapters.persistence.customer.repository;

import com.example.gasManager.application.ports.output.CustomerPersistencePort;
import com.example.gasManager.core.domain.model.Customer;
import com.example.gasManager.infrastructure.adapters.persistence.customer.entity.CustomerEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>, CustomerPersistencePort {
    @Override
    default <S extends Customer> S save(S customer) {
        return null;
    }

    @Override
    default Optional<Customer> findByName(String customerName) {
        return Optional.empty();
    }

    @Override
    default Boolean existsByName(String customerName) {
        return null;
    }

    @Override
    default void flush() {

    }

    @Override
    default <S extends CustomerEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends CustomerEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default void deleteAllInBatch(Iterable<CustomerEntity> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default CustomerEntity getOne(Long aLong) {
        return null;
    }

    @Override
    default CustomerEntity getById(Long aLong) {
        return null;
    }

    @Override
    default CustomerEntity getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends CustomerEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends CustomerEntity> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    default <S extends CustomerEntity> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    default <S extends CustomerEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends CustomerEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends CustomerEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends CustomerEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    default <S extends CustomerEntity> S save(S entity) {
        return null;
    }

    @Override
    default <S extends CustomerEntity> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default Optional<CustomerEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default List<CustomerEntity> findAll() {
        return List.of();
    }

    @Override
    default List<CustomerEntity> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(CustomerEntity entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends CustomerEntity> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<CustomerEntity> findAll(Sort sort) {
        return List.of();
    }

    @Override
    default Page<CustomerEntity> findAll(Pageable pageable) {
        return null;
    }
}
