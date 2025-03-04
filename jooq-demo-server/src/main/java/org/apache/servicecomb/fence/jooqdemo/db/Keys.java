/*
 * This file is generated by jOOQ.
 */
package org.apache.servicecomb.fence.jooqdemo.db;


import org.apache.servicecomb.fence.jooqdemo.db.tables.Actor;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Address;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Category;
import org.apache.servicecomb.fence.jooqdemo.db.tables.City;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Country;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Customer;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Film;
import org.apache.servicecomb.fence.jooqdemo.db.tables.FilmActor;
import org.apache.servicecomb.fence.jooqdemo.db.tables.FilmCategory;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Inventory;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Language;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Payment;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Rental;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Staff;
import org.apache.servicecomb.fence.jooqdemo.db.tables.Store;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.ActorRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.AddressRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.CategoryRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.CityRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.CountryRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.CustomerRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.FilmActorRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.FilmCategoryRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.FilmRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.InventoryRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.LanguageRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.PaymentRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.RentalRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.StaffRecord;
import org.apache.servicecomb.fence.jooqdemo.db.tables.records.StoreRecord;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ActorRecord> ACTOR_PKEY = Internal.createUniqueKey(Actor.ACTOR, DSL.name("actor_pkey"), new TableField[] { Actor.ACTOR.ACTOR_ID }, true);
    public static final UniqueKey<AddressRecord> ADDRESS_PKEY = Internal.createUniqueKey(Address.ADDRESS, DSL.name("address_pkey"), new TableField[] { Address.ADDRESS.ADDRESS_ID }, true);
    public static final UniqueKey<CategoryRecord> CATEGORY_PKEY = Internal.createUniqueKey(Category.CATEGORY, DSL.name("category_pkey"), new TableField[] { Category.CATEGORY.CATEGORY_ID }, true);
    public static final UniqueKey<CityRecord> CITY_PKEY = Internal.createUniqueKey(City.CITY, DSL.name("city_pkey"), new TableField[] { City.CITY.CITY_ID }, true);
    public static final UniqueKey<CountryRecord> COUNTRY_PKEY = Internal.createUniqueKey(Country.COUNTRY, DSL.name("country_pkey"), new TableField[] { Country.COUNTRY.COUNTRY_ID }, true);
    public static final UniqueKey<CustomerRecord> CUSTOMER_PKEY = Internal.createUniqueKey(Customer.CUSTOMER, DSL.name("customer_pkey"), new TableField[] { Customer.CUSTOMER.CUSTOMER_ID }, true);
    public static final UniqueKey<FilmRecord> FILM_PKEY = Internal.createUniqueKey(Film.FILM, DSL.name("film_pkey"), new TableField[] { Film.FILM.FILM_ID }, true);
    public static final UniqueKey<FilmActorRecord> FILM_ACTOR_PKEY = Internal.createUniqueKey(FilmActor.FILM_ACTOR, DSL.name("film_actor_pkey"), new TableField[] { FilmActor.FILM_ACTOR.ACTOR_ID, FilmActor.FILM_ACTOR.FILM_ID }, true);
    public static final UniqueKey<FilmCategoryRecord> FILM_CATEGORY_PKEY = Internal.createUniqueKey(FilmCategory.FILM_CATEGORY, DSL.name("film_category_pkey"), new TableField[] { FilmCategory.FILM_CATEGORY.FILM_ID, FilmCategory.FILM_CATEGORY.CATEGORY_ID }, true);
    public static final UniqueKey<InventoryRecord> INVENTORY_PKEY = Internal.createUniqueKey(Inventory.INVENTORY, DSL.name("inventory_pkey"), new TableField[] { Inventory.INVENTORY.INVENTORY_ID }, true);
    public static final UniqueKey<LanguageRecord> LANGUAGE_PKEY = Internal.createUniqueKey(Language.LANGUAGE, DSL.name("language_pkey"), new TableField[] { Language.LANGUAGE.LANGUAGE_ID }, true);
    public static final UniqueKey<PaymentRecord> PAYMENT_PKEY = Internal.createUniqueKey(Payment.PAYMENT, DSL.name("payment_pkey"), new TableField[] { Payment.PAYMENT.PAYMENT_ID }, true);
    public static final UniqueKey<RentalRecord> RENTAL_PKEY = Internal.createUniqueKey(Rental.RENTAL, DSL.name("rental_pkey"), new TableField[] { Rental.RENTAL.RENTAL_ID }, true);
    public static final UniqueKey<StaffRecord> STAFF_PKEY = Internal.createUniqueKey(Staff.STAFF, DSL.name("staff_pkey"), new TableField[] { Staff.STAFF.STAFF_ID }, true);
    public static final UniqueKey<StoreRecord> STORE_PKEY = Internal.createUniqueKey(Store.STORE, DSL.name("store_pkey"), new TableField[] { Store.STORE.STORE_ID }, true);
}
