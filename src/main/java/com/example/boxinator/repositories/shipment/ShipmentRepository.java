package com.example.boxinator.repositories.shipment;

import com.example.boxinator.models.account.Account;
import com.example.boxinator.models.shipment.Shipment;
import com.example.boxinator.models.shipment.ShipmentStatus;
import com.example.boxinator.models.shipment.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {


//    @Query(value =
//            "SELECT account.id, shipment.id, box_tier_id,  FROM account" +
//            "LEFT JOIN shipment on shipment.account_id = account.id" +
//            "WHERE shipment.account_id = ?", nativeQuery = true)
    List<Shipment> findAllByAccountId(Long accountId);


    @Query(value = "SELECT \n" +
            "shipment.shipment_id, shipment.account_id, shipment.box_color, shipment.cost, shipment.recipient, shipment.box_tier_id, shipment.country_id FROM shipment\n" +
            "LEFT JOIN shipment_status ON shipment_status.shipment_id = shipment.shipment_id\n" +
            "LEFT JOIN account ON shipment.account_id = account.account_id\n" +
            "LEFT JOIN country ON country.country_id = shipment.country_id\n" +
            "WHERE shipment.account_id = ?1 AND shipment_status.status = ?2", nativeQuery = true)
    List<Shipment> getShipmentsByStatus(Long accountId, Integer status);
}
